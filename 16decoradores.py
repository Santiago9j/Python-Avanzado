#Permiten alterar el funcionamiento


def decorador(funcionComun):
    def funcionDecorada():
        print('Mi funcion decorada')
    return funcionDecorada()



@decorador
def funcionComun():
    print('Mi funcion comun')