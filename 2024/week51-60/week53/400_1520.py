import sys

input=sys.stdin.readline

m,n=map(int,input().split())
Map=[list(map(int,input().split())) for _ in range(m)]

visit=[[-1 for _ in range(n)] for _ in range(m)]

di=[0,1,0,-1]
dj=[1,0,-1,0]
result=0
def dfs(i,j):
    if i==m-1 and j==n-1:
        return 1
    if visit[i][j]!=-1:
        return visit[i][j]
    visit[i][j]=0
    for k in range(4):
        ni,nj=i+di[k],j+dj[k]
        if 0<=ni<m and 0<=nj<n and Map[ni][nj]<Map[i][j]:
            visit[i][j]+=dfs(ni,nj)
    # for q in range(m):
    #     print(*visit[q])
    return visit[i][j]
print(dfs(0,0))