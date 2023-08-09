def lower(elemento):
    return elemento.lower() # Todo minuscula

lista = ['LAURa','JhoANA','si']

#Map,primero se le pasa la funcion, luego la lista que va a iterar en dicha funcion

print(list(map(lower,lista)))