import socket

HOST = '127.0.0.1'  # Endereco IP do Servidor
PORT = 5005            # Porta que o Servidor esta
udp = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
dest = (HOST, PORT)
msg = input('Informe nome, cargo e salario\n')

#enviando mensagem ao servidor 
udp.sendto (msg.encode(), dest)

#recebe resposta do servidor
data, server = udp.recvfrom(1024)
print(data.decode())

udp.close()
