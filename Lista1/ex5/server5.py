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
        
        idade = float(msg[0])

        if idade < 5:
            categoria = 'Nenhuma'

        elif idade >= 5 and idade <= 7:
            categoria = 'Infantil A'
        
        elif idade >= 8 and idade <= 10:
            categoria = 'Infantil B'
            
        elif idade >= 11 and idade <= 13:
            categoria = 'Juvenil A'
        
        elif idade >= 14 and idade <= 17:
            categoria = 'Juvenil B'
        
        elif idade >= 18:
            categoria = 'Adulto'
        
        conexao.send(categoria.encode()) #envia resultado ao cliente conectado
    
    print ('Finalizando conexao do cliente', cliente)
    conexao.close()
