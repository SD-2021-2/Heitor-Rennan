import socket
import json

HOST = '127.0.0.1'  # Endereco IP do Servidor
PORT = 6565            # Porta que o Servidor esta
skt = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
dest = (HOST, PORT)
skt.connect(dest)

nome = input('Informe o nome\n')

sexo = input('Informe o sexo\n')

idade = input('Informe a idade\n')

obj = {
    "nome": nome,
    "sexo": sexo,
    "idade": idade
}

msg = json.dumps(obj)

skt.sendall((msg+"\n").encode())

obj = skt.recv(1024)
data = json.loads(obj.decode())
print(data["maioridade"])
