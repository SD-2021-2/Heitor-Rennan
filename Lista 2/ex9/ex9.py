import socket
import json

HOST = '127.0.0.1'  # Endereco IP do Servidor
PORT = 6565            # Porta que o Servidor esta
skt = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
dest = (HOST, PORT)
skt.connect(dest)

numero = input('Informe o numero da carta\n')

naipe = input('Informe o naipe da carta (1 = ouros, 2 = paus, 3 = copas e 4 = espadas)\n')

obj = {
    "numero": numero,
    "naipe": naipe
}

msg = json.dumps(obj)

skt.sendall((msg+"\n").encode())

obj = skt.recv(1024)
data = json.loads(obj.decode())
print(data["extenso"])
