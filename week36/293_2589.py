import sys
from collections import deque

input=sys.stdin.readline

n,m=map(int,input().split())

mapmap=[list(input().strip()) for _ in range(n)]

visit=[[0 for _ in range(m)]for _ in range(n)]
di=[0,1,0,-1]
dj=[1,0,-1,0]
positive=[]
def bfs(i,j,flag):
    queue = deque()
    queue.append([i,j])
    visit[i][j]=1
    dis=0
    while queue:
        a,b=queue.popleft()
        count=0
        for k in range(4):
            ni=a+di[k]
            nj=b+dj[k]
            if ni<0 or ni>=n or nj<0 or nj>=m or mapmap[ni][nj]=="W" or visit[ni][nj]!=0:
                continue
            else:
                count+=1
                queue.append([ni,nj])
                visit[ni][nj]=visit[a][b]+1
                dis=max(visit[ni][nj],dis)
        if count<=2 and flag:
            positive.append([a,b])
    return dis

for i in range(n):
    for j in range(m):
        if mapmap[i][j]=="L" and visit[i][j]==0:
            bfs(i,j,True)
result=0
for i,j in positive:
    visit = [[0 for _ in range(m)] for _ in range(n)]
    if mapmap[i][j]=="L" and visit[i][j]==0:
        result=max(bfs(i,j,False),result)
print(result-1)