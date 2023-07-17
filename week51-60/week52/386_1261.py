import sys
from collections import deque

input=sys.stdin.readline

m,n=map(int,input().split())
mage=[list(map(int,list(input().strip()))) for _ in range(n)]
if n==1 and m==1:
    print(0)
    exit()
visit=[[0 for _ in range(m)] for _ in range(n)]
di=[0,1,0,-1]
dj=[1,0,-1,0]
new_queue=deque()
queue=deque()
queue.append([0,0])
visit[0][0]=1
result=0
while queue:
    result+=1
    while queue:
        i,j=queue.popleft()
        for k in range(4):
            ni=i+di[k]
            nj=j+dj[k]
            if ni==n-1 and nj==m-1:
                print(result-1)
                exit()
            if 0<=ni<n and 0<=nj<m and visit[ni][nj]==0:
                if mage[ni][nj]==0:
                    queue.append([ni,nj])
                else:
                    mage[ni][nj]=0
                    new_queue.append([ni,nj])
                visit[ni][nj] = 1
    queue=new_queue
    new_queue=deque()