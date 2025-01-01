import sys
import re
input=sys.stdin.readline

t=int(input())

for i in range(t):
    str1=input().strip()
    p=re.compile('(100+1+|01)+')
    m=p.fullmatch(str1)
    if m:
        print("YES")
    else:
        print("NO")
