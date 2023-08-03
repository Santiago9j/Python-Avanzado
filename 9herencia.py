#Clase padre

class Personal:
    def __init__(self, antiguedad, especialidad) -> None:
        self.antiguedad = antiguedad
        self.especialidad = especialidad
    
    def sueldo(self) -> int:
        if (self.especialidad == 'BF'):
            return 10 * self.antiguedad
        else:
            return 15 * self.antiguedad

#Clases hijas
#En parentesis, le indico la clase padre
class Supervisor(Personal):
    def __init__(self,cargo) -> None:
        super().__init__(5,cargo)

class Operador(Personal):
    def __init__(self,cargo) -> None:
        super().__init__(2, cargo)


if __name__ == '__main__':
    personal1 = Personal(10,'Jefe de Desarrollo')
    print(f"Sueldo del personal: {personal1.sueldo()}")

    supervisor = Supervisor('BF')
    print(f"El sueldo del supervisor {supervisor.sueldo()}")

    operador = Operador('De')
    print(f"El sueldo del supervisor {operador.sueldo()}")