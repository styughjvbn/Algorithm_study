import sys
from collections import deque

n,m=map(int,sys.stdin.readline().split())
mage=[]
for _ in range(n):
    mage.append(list(map(int,sys.stdin.readline().strip())))
queue=deque()
queue.append([0,0])
mage[0][0]=0
while len(queue):
    [x,y]=queue.popleft()
    if x>0 and mage[x-1][y]==1:
        queue.append([x-1,y])
        mage[x-1][y]=mage[x][y]+1
    if x<(n-1) and mage[x+1][y]==1:
        queue.append([x + 1, y])
        mage[x +1][ y] =mage[x][y]+1
    if y>0 and mage[x][y-1]==1:
        queue.append([x, y-1])
        mage[x][ y-1] =mage[x][y]+1
    if y<m-1 and mage[x][y+1]==1:
        queue.append([x, y + 1])
        mage[x][ y+1] =mage[x][y]+1

print(mage[n-1][m-1]+1)

