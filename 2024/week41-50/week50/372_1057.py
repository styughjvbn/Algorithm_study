import math
n,a,b=map(int,input().split())
result=0
if a>b:
    a,b=b,a
while b>1:
    result+=1
    if b%2==0 and a+1==b:
        break
    a=math.ceil(a/2)
    b=math.ceil(b/2)
print(result)