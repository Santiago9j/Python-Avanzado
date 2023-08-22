import zipfile
from zipfile import ZipFile

with zipfile.ZipFile('archivo.zip', 'w') as fzip:
    fzip.write('file.json')  #Agregar archivos del comprimido
    fzip.printdir() #Mostrar detalles de cada uno de los archivos
    fzip.extractall()  #Extrae todos los documentos