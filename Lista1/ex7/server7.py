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
        servico = float(msg[1])

        response = "Não pode aposentar"

        if (idade >= 65 and servico >= 30) or (idade >= 60 and servico >= 25):
            response = "Pode aposentar"
        
        conexao.send(response.encode()) #envia resultado ao cliente conectado
    
    print ('Finalizando conexao do cliente', cliente)
    conexao.close()
