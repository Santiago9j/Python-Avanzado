def generarPares(limites):
    num = 1
    while num<=limites:
        # Yield permite generar valores uno a uno en vez de todas al mismo tiempo
        yield num*2
        num+=1
    
devolverPares = generarPares(3)

print(next(devolverPares)) # 2
print(next(devolverPares)) # 4

def generaPares(n):
    num = 1 
    while num <= n:
        yield num * 2
        num+=1 
n = 10
for num in generaPares(n):
    print(num)