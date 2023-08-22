import re

print(re.search(r'j',"hoanja")) #<re.Match object; span=(4, 5), match='j'>

print(re.search(r'\d\d', "a12b")) #<re.Match object; span=(1, 3), match='12'>