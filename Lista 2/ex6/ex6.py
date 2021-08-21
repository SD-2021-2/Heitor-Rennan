import socket
import json

HOST = '127.0.0.1'  # Endereco IP do Servidor
PORT = 6565            # Porta que o Servidor esta
skt = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
dest = (HOST, PORT)
skt.connect(dest)

nome = input('Informe o nome\n')

nivel = input('Informe o nivel\n')

salario = input('Informe o salario\n')

dependentes = input('Informe a quantidade de dependentes\n')

obj = {
    "nome": nome,
    "nivel": nivel,
    "salario": salario,
    "dependentes": dependentes
}

msg = json.dumps(obj)

skt.sendall((msg+"\n").encode())

obj = skt.recv(1024)
data = json.loads(obj.decode())
print(data["salario liquido"])
