class Lavadora:

    def __init__(self) -> None:
        pass

    #Metodo privados con un _ antes del nombre

    def _llenar_tanque_de_agua(self, temp):
        print(f'Llenando el tanque con agua {temp}')

    def _anadir_jabon(self):
        print('Añadiendo jabón')

    def _lavar(self):
        print("Lavando")

    def _centrifugar(self):
        print("Centrifugando la ropa")

    def lavar(self, temp='caliente'): 
        self._llenar_tanque_de_agua(temp)
        self._anadir_jabon()
        self._lavar()
        self._centrifugar()

if __name__ == '__main__':
    lavadora = Lavadora()
    lavadora.lavar()