class Intro():
    nacionalidad = 'Colombiana'

    def __init__(self) -> None:
        pass

dato = Intro()

#Saber si un objeto es una instacia de una clase.
print(isinstance(dato, Intro)) #True
#Saber si un objeto tiene una variable de clase
print(hasattr(dato,'nacionalidad')) #True