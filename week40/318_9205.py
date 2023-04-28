import sys
from collections import deque
input=sys.stdin.readline

t=int(input())
for _ in range(t):
    n=int(input())
    point=[]
    for i in range(n+2):
        x,y=map(int,input().split())
        point.append((x,y))
    visit=[0 for _ in range(n+2)]
    queue=deque()
    queue.append(0)
    visit[0]=1
    happy=False
    while queue:
        num=queue.popleft()
        if num==n+1:
            happy=True
            break
        for k in range(1,n+2):
            dist=abs(point[num][0]-point[k][0])+abs(point[num][1]-point[k][1])
            if visit[k]==0 and dist<=1000:
                visit[k]=1
                queue.append(k)
    if happy:
        print("happy")
    else:
        print("sad")