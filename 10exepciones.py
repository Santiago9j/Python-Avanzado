#Exepciones: Capturandolos

lista = [1,2,3]
#print(lista[3]) Error de IndexErro

try:
    print(lista[3])
except IndexError:
    print('No existe')
else:
    print('No hay ningun error')
finally:
    print('Se ejecuto el script correctamente')