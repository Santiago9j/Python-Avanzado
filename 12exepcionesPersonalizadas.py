#Personalizando errores
class Err(Exception):
    def __init__(self,valor):
        print(f'Se causo un error por:{valor}')

try:
    raise Err(2)
except Err:
    print('Error escrito')