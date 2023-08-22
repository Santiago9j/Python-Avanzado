#Leer archivos JSON

import json

with open('file.json') as file:
    data = json.load(file)

print(data) #Toda la información
print(data['cliente1']) #Info en específico
