import sys
from collections import deque
#remove와 append이 잡아먹는 시간은 생각보다 크다... 꼭 필요할 때가 아니라면 쓰지말자
queue=deque()
n,m,l=map(int,sys.stdin.readline().split())
box=[]
for k in range(l):
    layer=[]
    for i in range(m):
        temp=(list(map(int,sys.stdin.readline().split())))
        for j in range(n):
            if temp[j]==1:
                queue.append([k, i, j])
        layer.append(temp)
    box.append(layer)

dk = [0, 0, 0, 0,1,-1]
di=[0,1,0,-1,0,0]
dj=[1,0,-1,0,0,0]

while len(queue):
    k,i,j=queue.popleft()
    for a in range(6):
        next_k=k+dk[a]
        next_i=i+di[a]
        next_j=j+dj[a]
        if next_i>=m or next_i<0 or next_j>=n or next_j<0 or next_k>=l or next_k<0:
            continue
        else:
            if box[next_k][next_i][next_j]==0:
                queue.append([next_k,next_i,next_j])
                box[next_k][next_i][next_j] = box[k][i][j]+1
result=0
for k in range(l):
    for i in range(m):
        for j in range(n):
            if box[k][i][j]==0:
                print(-1)
                exit()
            elif box[k][i][j]>1:
                result=max(box[k][i][j],result)

if result>0:
    print(result-1)
else:
    print(0)


