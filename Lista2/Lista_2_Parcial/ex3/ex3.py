import socket
import json

HOST = '127.0.0.1'  # Endereco IP do Servidor
PORT = 6565            # Porta que o Servidor esta
skt = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
dest = (HOST, PORT)
skt.connect(dest)

n1 = input('Informe a nota 1\n')

n2 = input('Informe a nota 2\n')

n3 = input('Informe a nota 3\n')

obj = {
    "n3": n1,
    "n2": n2,
    "n1": n3
}

msg = json.dumps(obj)

skt.sendall((msg+"\n").encode())

res = skt.recv(1024)
data = json.loads(res.decode())
print(data["resultado"])
