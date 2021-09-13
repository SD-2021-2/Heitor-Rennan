import socket
import json

HOST = '127.0.0.1'  # Endereco IP do Servidor
PORT = 6565            # Porta que o Servidor esta
skt = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
dest = (HOST, PORT)
skt.connect(dest)

idade = input('Informe a idade\n')

obj = {
    "idade": idade
}

msg = json.dumps(obj)

skt.sendall((msg+"\n").encode())

res = skt.recv(1024)
data = json.loads(res.decode())
print(data["categoria"])
