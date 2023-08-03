class Persona:
    #Constructor por defecto, no recibe parametros
    def __init__(self):
        pass

    #Metodos de clase
    @classmethod
    def saludar(cls, nombre):
        print(f'Te saludo desde mi metodo de clase. \n Mi nombre es: {nombre}')


#Llamando metodo de clase
Persona.saludar('Laura')