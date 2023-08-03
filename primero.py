class Persona:
    edad = 20 # Variables de clase
    def __init__(self, nombre, nacionalidad): # Varibales de instancia
        self.nombre = nombre
        self.nacionalidad = nacionalidad

    # Metodos de instancia
    def correr(self): 
        print('Yo estoy corriendo...')

# Imprimiendo variable de clase
print(Persona.edad)
persona1 = Persona('Jhoana','Colombia')
# Imprimiendo variables de instancia
print(persona1.nombre)

#Imprimiendo metodos de instancia
persona1.correr()
