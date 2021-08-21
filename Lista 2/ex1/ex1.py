import socket
import json

HOST = '127.0.0.1'  # Endereco IP do Servidor
PORT = 6565            # Porta que o Servidor esta
skt = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
dest = (HOST, PORT)
skt.connect(dest)

nome = input('Informe nome do funcionario\n')

cargo = input('Informe cargo do funcionario\n')

salario = input('Informe salario do funcionario\n')

obj = {
    "nome": nome,
    "cargo": cargo,
    "salario": salario
}

msg = json.dumps(obj)

skt.sendall((msg+"\n").encode())

obj = skt.recv(1024)
data = json.loads(obj.decode())
print(data["reajuste"])
