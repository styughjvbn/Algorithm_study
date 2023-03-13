import sys
from collections import deque

input=sys.stdin.readline
M,N=map(int,input().split())
mage=[]
for i in range(N):
    mage.append(input().strip())

visit=[[-1 for _ in range(M)] for _ in range(N)]
visit[0][0]=0
queue=deque()
queue.append([0,0])
da=[0,1,0,-1]
db=[1,0,-1,0]
while queue:
    a,b=queue.popleft()
    for i in range(4):
        na=a+da[i]
        nb=b+db[i]
        if na<0 or nb<0 or na>=N or nb>=M or visit[na][nb]!=-1:
            continue
        else:
            if mage[na][nb]=='1':
                queue.append([na,nb])
                visit[na][nb]=visit[a][b]+1
            else:
                queue.appendleft([na, nb])#일반적인 큐를 이용한 BFS와는 다른 점 : 벽을 부수지 않고 이동하기 때문에 우선적으로 이길을 선택해서 경로를 선택하면 되기 때문에 큐의 맨 앞에 넣어준다.
                visit[na][nb]=visit[a][b]
print(visit[N-1][M-1])