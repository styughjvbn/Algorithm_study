import sys

input=sys.stdin.readline

n,l=map(int,input().split())
tape=sorted(list(map(int,input().split())))
result=0
length=0
for i in range(n-1):
    if tape[i+1]-tape[i]<l:
        length+=tape[i+1]-tape[i]
        continue
    else:
        if length:
            result+=length//l+1
        else:
            result+=1
        length=0
else:
    if length:
        result += length // l + 1
    else:
        result += 1
print(result)