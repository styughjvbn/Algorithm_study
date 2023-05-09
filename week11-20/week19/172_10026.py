import sys
from collections import deque

input=sys.stdin.readline

n=int(input())

paper=[]
for i in range(n):
    paper.append(list(input().strip()))

visit=[[0 for _ in range(n)]for _ in range(n)]

queue=deque()
di=[0,1,0,-1]
dj=[1,0,-1,0]
count=1
for i in range(n):
    for j in range(n):
        if visit[i][j]==0:
            queue.append([i,j])
            visit[i][j]=count
            color = paper[i][j]
            while queue:
                a,b=queue.popleft()
                for k in range(4):
                    next_i=a+di[k]
                    next_j = b + dj[k]
                    if next_i<0 or next_j<0 or next_i>n-1 or next_j>n-1:
                        continue
                    else:
                        if visit[next_i][next_j]==0:
                            if color=='B':
                                if paper[next_i][next_j] == 'B':
                                    visit[next_i][next_j] = count
                                    queue.append([next_i, next_j])
                            else:
                                if paper[next_i][next_j]!="B":
                                    visit[next_i][next_j]=count
                                    queue.append([next_i, next_j])
            count+=1
visit=[[0 for _ in range(n)]for _ in range(n)]
normalcount=1
for i in range(n):
    for j in range(n):
        if visit[i][j]==0:
            queue.append([i,j])
            visit[i][j]=normalcount
            color = paper[i][j]
            while queue:
                a,b=queue.popleft()
                for k in range(4):
                    next_i=a+di[k]
                    next_j = b + dj[k]
                    if next_i<0 or next_j<0 or next_i>n-1 or next_j>n-1:
                        continue
                    else:
                        if visit[next_i][next_j]==0:
                            if paper[next_i][next_j] == color:
                                visit[next_i][next_j] = normalcount
                                queue.append([next_i, next_j])
            normalcount+=1
print(normalcount-1,count-1,)
