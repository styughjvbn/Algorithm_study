import sys
from collections import deque

input=sys.stdin.readline

n,m=map(int,input().split())
case=1
while n!=0:
    vertex=[[]for _ in range(n+1)]
    for i in range(m):
        a,b=map(int,input().split())
        vertex[a].append(b)
        vertex[b].append(a)
    visit=[0]*(n+1)
    count=1
    treecount=0
    for i in range(1,n+1):
        if visit[i]==0:
            flag = True
            queue=deque()
            queue.append([i,0])
            visit[i]=count
            while len(queue):
                v,prev=queue.popleft()
                for k in vertex[v]:
                    if k==prev:
                        continue
                    else:
                        if visit[k]==0:
                            queue.append([k,v])
                            visit[k]=count
                        else:
                            flag=False
            if flag:
                treecount+=1
    if treecount==0:
        print("Case "+str(case)+": No trees.")
    elif treecount==1:
        print("Case " + str(case) + ": There is one tree.")
    else:
        print("Case " + str(case) + ": A forest of "+str(treecount)+" trees.")
    n, m = map(int, input().split())

    case+=1
