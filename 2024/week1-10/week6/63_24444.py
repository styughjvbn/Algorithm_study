import sys
from collections import deque
sys.setrecursionlimit(10 ** 6)

n,m,r=map(int,sys.stdin.readline().split())
v=[0 for i in range(n+1)]
e=[[] for i in range(n+1)]
queue=deque()
queue.append(r)
v[r]=1

for i in range(1,m+1):
    start,end=map(int,sys.stdin.readline().split())
    e[start].append(end)
    e[end].append(start)

number=2
while len(queue):
    iter=queue.popleft()
    e[iter].sort()
    for i in e[iter]:
        if v[i]==0:
            v[i]=number
            number+=1
            queue.append(i)

for i in range(1,n+1):
    print(v[i])
