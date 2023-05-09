from collections import deque

n,k=map(int,input().split())
queue=deque([i for i in range(1,n+1)])
print("<",end="")
count=0
while queue:
    x=queue.popleft()
    count+=1
    if count!=k:
        queue.append(x)
    else:
        if len(queue)==0:
            print(str(x), end="")
        else:
            print(str(x) + ", ", end="")
        count=0
print(">")