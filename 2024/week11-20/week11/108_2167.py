import sys

n,m=map(int,sys.stdin.readline().split())
arr=[]
for i in range(n):
    arr.append(list(map(int,sys.stdin.readline().split())))

for i in range(n):
    sum = 0
    for j in range(m):
        sum+=arr[i][j]
        arr[i][j]=sum

k=int(sys.stdin.readline())
for i in range(k):
    a,b,c,d=map(lambda f:int(f)-1,sys.stdin.readline().split())
    result=0
    for f in range(a,c+1):
        if b<1:
            result+=arr[f][d]
        else:
            result+=arr[f][d]-arr[f][b-1]
    print(result)
