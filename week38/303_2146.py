import sys
from collections import deque
input=sys.stdin.readline

n=int(input())
world=[]
for i in range(n):
    world.append(list(map(int,input().split())))

continent=0
graph=[[0 for i in range(n)]for i in range(n)]
di=[0,1,0,-1]
dj=[1,0,-1,0]
for i in range(n):
    for j in range(n):
        if world[i][j]==1 and graph[i][j]==0:
            continent+=1
            queue=deque()
            queue.append([i,j])
            graph[i][j]=continent
            while queue:
                a,b=queue.popleft()
                for k in range(4):
                    n_a=a+di[k]
                    n_b = b + dj[k]
                    if n_a<0 or n_a>=n or n_b<0 or n_b>=n or world[n_a][n_b]==0 or graph[n_a][n_b]!=0:
                        continue
                    else:
                        graph[n_a][n_b]=continent
                        queue.append([n_a,n_b])
# for i in range(n):
#     print(*graph[i])
min_len=500
for i in range(n):
    for j in range(n):
        if graph[i][j]!=0:
            is_beach=False
            for k in range(4):
                n_a = i + di[k]
                n_b = j + dj[k]
                if n_a < 0 or n_a >= n or n_b < 0 or n_b >= n:
                    continue
                else:
                    if graph[n_a][n_b] == 0:
                        is_beach=True
                        break
            if is_beach:
                queue = deque()
                queue.append([i, j])
                visit=[[0 for i in range(n)]for i in range(n)]
                visit[i][j] = 1
                end=False
                while queue:
                    if end:
                        break
                    a, b = queue.popleft()
                    for k in range(4):
                        n_a = a + di[k]
                        n_b = b + dj[k]
                        if n_a < 0 or n_a >= n or n_b < 0 or n_b >= n or graph[n_a][n_b] == graph[i][j] or visit[n_a][n_b] != 0:
                            continue
                        else:
                            if graph[n_a][n_b]!=0:
                                min_len=min(visit[a][b],min_len)
                                end=True
                                break
                            else:
                                visit[n_a][n_b] = visit[a][b]+1
                                queue.append([n_a, n_b])
print(min_len-1)