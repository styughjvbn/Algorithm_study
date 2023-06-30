import sys
from collections import deque
input=sys.stdin.readline

t=int(input())
dx=[1,0,-1,0]
dy=[0,1,0,-1]
for _ in range(t):
    m,n,k=map(int,input().split())
    field=[[0 for _ in range(m)]for _ in range(n)]
    for i in range(k):
        a,b=map(int,input().split())
        field[b][a]=1

    worm_count=0
    for i in range(n):
        for j in range(m):
            if field[i][j]==1:
                worm_count+=1
                queue=deque()
                queue.append([i,j])
                #큐를 이용한 너비우선탐색
                while queue:
                    y,x=queue.popleft()
                    for k in range(4):
                        nx=x+dx[k]
                        ny=y+dy[k]
                        if -1<nx<m and -1<ny<n and field[ny][nx]==1:
                            queue.append([ny,nx])
                            field[ny][nx]=0

    print(worm_count)