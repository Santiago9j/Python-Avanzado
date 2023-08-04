#Hilo: Unidad de proceseamiento más pequeña que se pueda ejecutar. 

import threading
import time

#Esta clase hereda de Htread
class Hilo(threading.Thread):
    #Este metodo
    def run(self):
        print(f"Incio: {self.name}")
        time.sleep(1)
        print(f"Terminado: {self.name}")

if __name__ == '__main__':
    for i in range(4):
        hilo = Hilo(name=f"Hilo {i+1}")
        hilo.start()
        time.sleep(.1)
