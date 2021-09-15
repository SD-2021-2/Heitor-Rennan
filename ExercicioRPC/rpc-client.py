import xmlrpc.client

with xmlrpc.client.ServerProxy("http://localhost:8000/") as proxy:

    somaService = proxy.getService('exerc4')
    print(somaService)
    url = 'http://' + str(somaService['host']) + ':' + str(somaService['port'])
    print(url)
    with xmlrpc.client.ServerProxy(url) as proxy2:
        try:
            print(proxy2.exerc4(1.65, "F"))
            print(proxy2.exerc5(15))
        except Exception as e:
            print('Serviço indisponível !!' , e)
    

    