import sys
from collections import deque

input=sys.stdin.readline

M,N,K=map(int,input().split())
paper=[[0 for _ in range(N)] for _ in range(M)]
for _ in range(K):
    x1,y1,x2,y2=map(int,input().split())
    for i in range(x1,x2):
        for j in range(y1,y2):
            paper[j][i]=1


count=0
areas=[]
da=[0,1,0,-1]
db=[1,0,-1,0]
for i in range(M):
    for j in range(N):
        if paper[i][j]==0:
            queue=deque()
            queue.append([i,j])
            paper[i][j]=1
            area=1
            while queue:
                a,b=queue.popleft()
                for k in range(4):
                    next_a=a+da[k]
                    next_b=b+db[k]
                    if next_a>=M or next_a<0 or next_b>=N or next_b<0 or paper[next_a][next_b]!=0:
                        continue
                    else:
                        queue.append([next_a,next_b])
                        paper[next_a][next_b]=1
                        area+=1
            count+=1
            areas.append(area)

print(count)
print(*sorted(areas))