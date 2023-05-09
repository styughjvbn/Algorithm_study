import sys

n=int(sys.stdin.readline())
m=int(sys.stdin.readline())

distance=[[int(1e9) for _ in range(n+1)]for _ in range(n+1)]

for i in range(m):
    a,b,c=map(int,sys.stdin.readline().split())
    distance[a][b]=min(distance[a][b],c)
for i in range(1,n+1):
    distance[i][i]=0

for i in range(1,n+1):
    for j in range(1,n+1):
        for k in range(1,n+1):
            if i==j:
                continue
            else:
                if distance[j][i]!=int(1e9) and distance[i][k]!=int(1e9):
                    distance[j][k]=min(distance[j][k],distance[j][i]+distance[i][k])

for i in range(1,n+1):
    for j in range(1,n+1):
        if distance[i][j]==int(1e9):
            print(0,end=" ")
        else:
            print(distance[i][j],end=" ")
    print()


