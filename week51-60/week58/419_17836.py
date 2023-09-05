import sys
from collections import deque
input=sys.stdin.readline

N,M,T=map(int,input().split())
mage=[]
for i in range(N):
    line=list(map(int,input().split()))
    mage.append(line)

di=[0,1,0,-1]
dj=[1,0,-1,0]
visit=[[[0,0] for _ in range(M)] for _ in range(N)]
queue=deque()
queue.append([0,0,False])
visit[0][0]=[1,0]

while queue:
    cur_pos=queue.popleft()
    if sum(visit[cur_pos[0]][cur_pos[1]])>T:
        print("Fail")
        exit()
    for i in range(4):
        ni=cur_pos[0]+di[i]
        nj=cur_pos[1]+dj[i]
        if 0<=ni<N and 0<=nj<M :
            if ni== N-1 and nj==M-1 :
                print(sum(visit[cur_pos[0]][cur_pos[1]]))
                exit()
            if not cur_pos[2] and visit[ni][nj][0]==0:
                if mage[ni][nj]!=1:
                    if mage[ni][nj]==2:
                        visit[ni][nj]=[visit[cur_pos[0]][cur_pos[1]][0],visit[cur_pos[0]][cur_pos[1]][1]+1]
                        queue.append([ni,nj,True])
                    else:
                        visit[ni][nj]=[visit[cur_pos[0]][cur_pos[1]][0]+1,visit[cur_pos[0]][cur_pos[1]][1]]
                        queue.append([ni,nj,False])
            elif cur_pos[2] and visit[ni][nj][1]==0:
                visit[ni][nj]=[visit[cur_pos[0]][cur_pos[1]][0],visit[cur_pos[0]][cur_pos[1]][1]+1]
                queue.append([ni,nj,True])
    # for i in range(N):
    #     print(*visit[i])
    # print()
print("Fail")

