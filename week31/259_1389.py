import sys

input=sys.stdin.readline

N,M=map(int,input().split())
dist=[[200 for _ in range(N)] for _ in range(N)]
for i in range(M):
    a,b=map(int,input().split())
    dist[a-1][b-1]=1
    dist[b - 1][a - 1] = 1
    dist[a-1][a-1]=0
    dist[b-1][b-1]=0

for i in range(N):
    for j in range(N):
        for k in range(N):
            dist[j][k]=min(dist[j][i]+dist[i][k],dist[j][k])


result=0
prev_temp=200
for i in range(N):
    temp =0
    for j in range(N):
        temp+=dist[i][j]
    if prev_temp>temp:
        result=i
        prev_temp=temp

print(result+1)