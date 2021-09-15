import xmlrpc.client
from xmlrpc.server import SimpleXMLRPCServer


# DEFININDO UM SERVIÇO
def exerc4(altura, sexo):
    if sexo == "M":
        return (72.7 * altura) - 58
    elif sexo == "F":
        return (62.1 * altura) - 44.7
    else:
        return False

def exerc5(idade):
    if idade >= 18:
        return "Adulto"
    elif idade >= 14:
        return "Juvenil B"
    elif idade >= 11:
        return "Juvenil A"
    elif idade >= 8:
        return "Infantil B"
    elif idade >= 5:
        return "Infantil A"
    else:
        return "Sem categoria"

def is_valid():
    return True


# PUBLICANDO SERVIÇOS NO SERVIDOR DE NOMES
with xmlrpc.client.ServerProxy("http://localhost:8000/") as proxy:
    print('....................................')
    print('Registrando serviço de exerc4')
    proxy.serviceRegister('exerc4', 'localhost', '8001')
    proxy.serviceRegister('exerc5', 'localhost', '8001')
    #proxy.unregisteService('192.168.1.100')


# SUBINDO O SERVIDOR E REGISTRANDO O SERVIÇO
server = SimpleXMLRPCServer(("localhost", 8001))
print("Listening in port 8001 ...")
server.register_function(exerc4, "exerc4")
server.register_function(exerc5, "exerc5")
server.register_function(is_valid, 'is_valid')
server.serve_forever()