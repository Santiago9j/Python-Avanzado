#Personalizando errores
#Estructura
#Se crea una clase que herede de Exception
class Err(Exception):
    def __init__(self,valor): 
        print(f'Se causo un error por:{valor}')  

try:
    raise Err(2)
except Err:
    print('Error escrito')

#Ejemplo de una exepcion personalizada

#Importante: 
print(isinstance(2, int)) #True
print(isinstance('4', int)) #False

#Saber su un caracter está en un String
print('5' in "342") #False
print('5' not in "342") #True
print('3' in "342") #True
print("34" in "342") #True
print("43" in "342") #False

class Err(Exception):
    def __init__(self, valor):
        try:
            if not isinstance(valor, int):
                raise ValueError("El valor debe ser un número entero.")
            if '5' not in str(valor):
                raise ValueError("El número debe contener el dígito 5.")
        except ValueError as ve:
            print(f'Se causó un error: {ve}')
        else:
            print(f'El valor es válido: {valor}')

try:
    raise Err(2)  # Esto causará un error porque el valor no contiene el dígito 5.
except Err:
    print('Error escrito')

try:
    raise Err(55)  # Funciona
except Err:
    print('Error escrito')

try:
    raise Err(25)  # Esto funciona
except Err:
    print('Error escrito')


