import socket
import json

HOST = '127.0.0.1'  # Endereco IP do Servidor
PORT = 6565            # Porta que o Servidor esta
skt = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
dest = (HOST, PORT)
skt.connect(dest)

nome = input('Informe o nome do aluno\n')

obj = {
    "nome": nome
}

msg = json.dumps(obj)

skt.sendall((msg+"\n").encode())

res = skt.recv(1024)
data = json.loads(res.decode())
print(data["resultado"])
