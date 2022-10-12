import sys
from collections import deque

n,m=map(int,sys.stdin.readline().split())
board=[]
visit=[[0for _ in range(m)]for _ in range(n)]
cheese_count=0
prev_cheese_count=0
for i in range(n):
    board.append(list(map(int,sys.stdin.readline().split())))
    for j in board[i]:
        if j==1:
            cheese_count+=1

di=[0,1,0,-1]
dj=[1,0,-1,0]
result=0
while cheese_count:
    queue=deque()
    queue.append([0,0])
    visit = [[0 for _ in range(m)] for _ in range(n)]
    visit[0][0]=1
    prev_cheese_count=cheese_count
    while len(queue):
        i,j=queue.popleft()
        for k in range(4):
            next_i=i+di[k]
            next_j=j+dj[k]
            if next_i>=n or next_i<0 or next_j>=m or next_j<0:
                continue
            else:
                if board[next_i][next_j]==1:
                    if visit[next_i][next_j]==0:
                        board[next_i][next_j]=0
                        visit[next_i][next_j]=1
                        cheese_count-=1
                elif board[next_i][next_j]==0:
                    if visit[next_i][next_j] == 0:
                        queue.append([next_i,next_j])
                        visit[next_i][next_j]=1
    result+=1
print(result)
print(prev_cheese_count)
