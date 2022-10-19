import sys
from collections import deque

N,M=map(int,sys.stdin.readline().split())

box=[]
count=0
for i in range(N):
    line=list(map(int,sys.stdin.readline().split()))
    box.append(line)
    for j in range(M):
        if box[i][j]==1:
            count+=1

queue=deque()
di=[0,1,0,-1]
dj=[1,0,-1,0]
# for i in range(N):
#     print(*box[i])
# print()
result=0
while count:
    queue.append([0,0])
    visit=[[0for _ in range(M)]for _ in range(N)]
    visit[0][0]=1
    while len(queue):
        i,j=queue.popleft()
        for k in range(4):
            next_i=i+di[k]
            next_j = j + dj[k]
            if next_i<0 or next_i>N-1 or next_j<0 or next_j>M-1:
                continue
            else:
                if visit[next_i][next_j]==0:
                    if box[next_i][next_j]==0:
                        queue.append([next_i,next_j])
                        visit[next_i][next_j]=1
                    else:
                        visit[next_i][next_j] = 1
                else:
                    if visit[next_i][next_j] == 1and box[next_i][next_j]==1:
                        visit[next_i][next_j] = 2

    for i in range(N):
        for j in range(M):
            if box[i][j]==1 and visit[i][j]==2:
                count-=1
                box[i][j]=0
    # for i in range(N):
    #     print(*box[i])
    # print()
    result+=1
print(result)