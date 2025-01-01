import sys
from collections import deque

n,m=map(int,sys.stdin.readline().split())

board=[0]*101
road={}
for i in range(1,101):
    road[i]=i
for i in range(n+m):
    start,end=map(int,sys.stdin.readline().split())
    road[start]=end

queue=deque()
queue.append(1)
result=0
six=6
while len(queue):
    pos=queue.popleft()
    for i in range(1,7):
        next=road[pos+i]
        if board[next]==0:
            queue.append(next)
            board[next]=board[pos]+1
        if next==100:
            print(board[100])
            exit()