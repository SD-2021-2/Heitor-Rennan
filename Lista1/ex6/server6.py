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
        
        nome = msg[0].decode()
        nivel = msg[1].decode()
        salario = float(msg[2])
        dependentes = float(msg[3])

        if nivel == 'A':
          if dependentes > 0:
            salario -= salario * 0.08
          else:
            salario -= salario * 0.03
        elif nivel == 'B':
          if dependentes > 0:
            salario -= salario * 0.10
          else:
            salario -= salario * 0.05
        elif nivel == 'C':
          if dependentes > 0:
            salario -= salario * 0.15
          else:
            salario -= salario * 0.08
        elif nivel == 'D':
          if dependentes > 0:
            salario -= salario * 0.17
          else:
            salario -= salario * 0.10

        response = nome + " " + nivel + " " + str(salario)
        
        conexao.send(response.encode()) #envia resultado ao cliente conectado
    
    print ('Finalizando conexao do cliente', cliente)
    conexao.close()
