import sys
from collections import deque
input=sys.stdin.readline

n,m=map(int,input().split())
paper=[list(map(int,input().split())) for _ in range(n)]
visit=[[0 for _ in range(m)]for _ in range(n)]
result=1
max_area=0
di=[0,1,0,-1]
dj=[1,0,-1,0]
for i in range(n):
    for j in range(m):
        if paper[i][j]==1 and visit[i][j]==0:
            queue=deque()
            queue.append([i,j])
            visit[i][j]=result
            temp_area=1
            while queue:
                a,b=queue.popleft()
                for k in range(4):
                    n_a=a+di[k]
                    n_b=b+dj[k]
                    if n_a >= n or n_a<0 or n_b>=m or n_b<0 or paper[n_a][n_b]==0 or visit[n_a][n_b]!=0:
                        continue
                    else:
                        queue.append([n_a,n_b])
                        visit[n_a][n_b]=result
                        temp_area+=1
            max_area=max(max_area,temp_area)
            result+=1

print(result-1)
print(max_area)
