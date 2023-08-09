def lower(elemento):
    return elemento.lower() # Todo minuscula

lista = ['LAURa','JhoANA','si']

#Map,primero se le pasa la funcion, luego la lista que va a iterar en dicha funcion

print(list(map(lower,lista)))


def saludar(idioma):
    def saludar_es():
        print('Hola')
    def saludar_en():
        print('Hello')
    func_idioma = {
        'es':saludar_es,
        'en':saludar_en
    }
    return func_idioma[idioma]

el_saludo = saludar('es')
el_saludo()