import sys
from collections import deque
n=int(sys.stdin.readline())
k=int(sys.stdin.readline())
round=[[0for _ in range(n)]for _ in range(n)]
for _ in range(k):
    i,j=map(int,sys.stdin.readline().split())
    round[i-1][j-1]=1
l=int(sys.stdin.readline())
chg_dir=[0]*10001
for _ in range(l):
    i, j = sys.stdin.readline().split()
    chg_dir[int(i)] = j

snake=deque()
snake.append([0,0])
di=[0,1,0,-1]
dj=[1,0,-1,0]
direction=0
x=0
while True:
    x += 1
    next_i=snake[-1][0]+di[direction]
    next_j=snake[-1][1]+dj[direction]

    if next_i<0 or next_i>=n or next_j<0 or next_j>=n or [next_i,next_j] in snake:
        break
    else:
        snake.append([next_i, next_j])
        if chg_dir[x]=='D':
            direction=(direction+1)%4
        elif chg_dir[x]=='L':
            direction = (direction - 1) % 4
        if round[next_i][next_j]==1:
            round[next_i][next_j] =0
            continue
        else:
            snake.popleft()

print(x)



