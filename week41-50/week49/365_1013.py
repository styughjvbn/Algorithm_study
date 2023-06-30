import re
t=int(input())

for _ in range(t):
    if re.fullmatch("(100+1+|01)+",input().strip()):
        print("YES")
    else:
        print("NO")