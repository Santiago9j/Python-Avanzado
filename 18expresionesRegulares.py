import re

print(re.search(r'j',"hoanja")) #<re.Match object; span=(4, 5), match='j'>

print(re.search(r'\d\d', "a12b")) #<re.Match object; span=(1, 3), match='12'>


if (re.search('\Aa[0-9].*(end|fin)$','a4 es una marca de fin')): 
    print('Se cumple el patron')


#Sustituciones

#Va a sustituir todos los numeros por 7
print(re.sub(r'\d', '7', 'Hi, estoy cambiand4, t8dos los nu76mero2754 por 7'))

# Ahora bien, si quiero limitar el numero de cambios
print(re.sub(r'\d', '7', 'Hi, estoy cambiand4, t8dos los nu76mero2754 por 7',1))


#Modificadores


modificador = re.compile(r'ab', re.IGNORECASE)
print(modificador.search('Ab'))
