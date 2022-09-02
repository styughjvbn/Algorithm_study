import sys
from collections import deque

n,k=map(int,sys.stdin.readline().split())
queue=deque()
queue.append(n)
visit=[0]*100001
visit[n]=1
while len(queue):
    num=queue.popleft()
    if num>0 and visit[num-1]==0:
        queue.append(num-1)
        visit[num-1]=visit[num]+1
        if num-1==k:
            break
    if num<100000 and visit[num+1]==0:
        queue.append(num+1)
        visit[num + 1] = visit[num] + 1
        if num+1==k:
            break
    if num*2<100001 and visit[num*2]==0:
        queue.append(num*2)
        visit[num*2] = visit[num] + 1
        if num*2==k:
            break

print(visit[k]-1)
