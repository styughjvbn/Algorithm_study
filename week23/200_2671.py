import re

p = re.compile('(100+1+|01)+')

str1=input().strip()
if p.fullmatch(str1):
    print("SUBMARINE")
else:
    print("NOISE")