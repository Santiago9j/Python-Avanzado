class Circulo:
    def __init__(self, radio):
        self.radio = radio
    #Propiedades
    @property
    def area(self):
        return 1.004545*(self.radio ** 2)
    
c = Circulo(10)
print(c.area) #No hay que poner area(), sin parentesis está bien.