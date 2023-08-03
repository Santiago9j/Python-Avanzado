class Perro:
    def avanzar(self):
        print('Tengo 4 patas')
class Perico:
    def avanzar(self):
        print("Volar")

def mover(animal):  #Así es el polimorfismo...
    animal.avanzar()

perro = Perro()
perico = Perico()

print('Aca no hay polimorfismo')
perro.avanzar()
perico.avanzar()

print('Si hay polimorfismo')
mover(perro)
mover(perico)