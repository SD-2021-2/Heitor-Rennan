import socket

host = '127.0.0.1'  # Endereco IP do Servidor
porta = 5000           # Porta que o Servidor esta
tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
orig = (host, porta)

tcp.bind(orig)  #associando servidor ao endereço
tcp.listen(1)   #ouvindo pedidos de conexão

while True:
    conexao, cliente = tcp.accept() #aceita conexão do cliente
    print ('Conectado por', cliente)
    
    while True:
        msg = conexao.recv(1024)    #recebe mensagem do cliente
        msg = msg.split()

        if not msg: 
            break
        
        n1 = float(msg[0])
        n2 = float(msg[1])
        n3 = float(msg[2])

        if (n1 + n2)/2 >= 7:
            resultado = 'aprovado'
        
        elif (n1 + n2)/2 >= 3 and (n1 + n2)/2 < 7:
            if (n1 + n2 + n3)/3 >= 5:
                resultado = 'aprovado'
            
            else:
                resultado = 'reprovado'
        
        else:
            resultado = 'reprovado'
        
        conexao.send(resultado.encode()) #envia resultado ao cliente conectado
    
    print ('Finalizando conexao do cliente', cliente)
    conexao.close()
