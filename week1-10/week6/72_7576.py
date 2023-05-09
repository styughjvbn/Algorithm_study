import sys
from collections import deque

queue=deque()
n,m=map(int,sys.stdin.readline().split())
box=[]
for _ in range(m):
    box.append(list(map(int,sys.stdin.readline().split())))
unripe=[]
for i in range(m):
    for j in range(n):
        if box[i][j]==1:
            queue.append([i,j])
        elif box[i][j]==0:
            unripe.append([i,j])
if not len(unripe):
    print(0)
    exit()
di=[0,1,0,-1]
dj=[1,0,-1,0]
while len(queue):
    i,j=queue.popleft()
    for k in range(4):
        next_i=i+di[k]
        next_j=j+dj[k]
        if next_i>=m or next_i<0 or next_j>=n or next_j<0:
            continue
        else:
            if box[next_i][next_j]==0:
                queue.append([next_i,next_j])
                box[next_i][next_j] = box[i][j]+1
for i in range(m):
    for j in range(n):
        if box[i][j]==0:
            print(-1)
            exit()
print(max(map(max,box))-1)

