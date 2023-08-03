class Libro():
    def __init__(self, nombre, autor, paginas):
        self.nombre = nombre
        self.autor = autor
        self.paginas = paginas
    
    #Metodo String
    def __str__(self):
        return(f'{self.nombre} escrito por {self.autor}')
    
    #Metodo len
    def __len__(self):
        return self.paginas
    
    def __del__(self):
        print('Se ha eliminado el libro')
    
    
libro1 = Libro('Ejemplo','Daniel Saldarriaga',220)
# Con solo tener la clase libro el metodo string, returna dicho metodo solo printando el objeto
print(libro1) #Ejemplo escrito por Daniel Saldarriaga

#Permite saber la longitud: Ej: print(len('12'))  #2
#Si la clase no tuviera el metodo __len__ y quisieramos imprimir la linea 21, entonces saldria un herro diciendo que Libro no tiene una len
print(len(libro1)) # 220

#Metodo del: Eliminar un objeto. No es necesario que este dentro de la clase.
print(libro1)
del libro1 #Cuando se ejecuata este linea, se ejecuta el metodo del.

