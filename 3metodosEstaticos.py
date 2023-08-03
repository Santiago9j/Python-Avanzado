class Persona():
    def __init__(self):
        pass

    #Metodo de instancia
    def saltar(self):
        print('Estoy saltando')

    #Metodo de clase
    @classmethod
    def correr(cls):
        print('Estoy corriendo')

    #Metodo estatico
    @staticmethod
    def nadar():
        print('Estoy nadando')

pedro = Persona()
pedro.nadar()  # Estoy nadando

   
