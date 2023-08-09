def generarPares(limites):
    num = 1
    while num<=limites:
        yield num*2
        num+=1
    
devolverPares = generarPares(3)

print(next(devolverPares)) # 2
print(next(devolverPares)) # 4