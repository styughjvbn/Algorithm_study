import sys
from collections import deque
sys.setrecursionlimit(10 ** 6)

n,m,r=map(int,sys.stdin.readline().split())
v=[0 for i in range(n+1)]
e=[[] for i in range(n+1)]

for i in range(1,m+1):
    start,end=map(int,sys.stdin.readline().split())
    e[start].append(end)
    e[end].append(start)
a=1
def dfs(num):
    global v
    global e,a

    if v[num]!=0:
        return
    else:
        v[num] = 1
        print(num,end=" ")
        e[num].sort()
        for j in e[num]:
            dfs(j)
dfs(r)
print("")
v=[0 for i in range(n+1)]
queue=deque()
queue.append(r)
v[r]=1
print(r,end=" ")
while len(queue):
    iter=queue.popleft()
    e[iter].sort()
    for i in e[iter]:
        if v[i]==0:
            v[i]=1
            print(i, end=" ")
            queue.append(i)
