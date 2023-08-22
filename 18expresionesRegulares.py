import re

print(re.search(r'j',"hoanja")) #<re.Match object; span=(4, 5), match='j'>

print(re.search(r'\d\d', "a12b")) #<re.Match object; span=(1, 3), match='12'>


if (re.search('\Aa[0-9].*(end|fin)$','a4 es una marca de fin')): 
    print('Se cumple el patron')