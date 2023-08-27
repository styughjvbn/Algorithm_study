import sys,math

input=sys.stdin.readline
n=int(sys.stdin.readline())
result=0
rooms=list(map(int,input().split()))
b,c=map(int,input().split())
for i in rooms:
    result+=1
    i=i-b
    if i>0:
        result+=math.ceil(i/c)

print(result)