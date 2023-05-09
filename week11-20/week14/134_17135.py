import copy
import sys
from collections import deque

N,M,D=map(int,sys.stdin.readline().split())
real_world=[]
for i in range(N):
    temp=list(map(int,sys.stdin.readline().split()))
    real_world.append(temp)

combine=[]
for i in range(M):
    for j in range(i+1,M):
        for k in range(j+1,M):
            combine.append([i,j,k])

def bfs(pos,constrint):
    queue=deque()
    queue.append(pos)
    base=pos[0]
    visit=[[0 for _ in range(M)]for _ in range(N+1)]
    visit[pos[0]][pos[1]]=1
    di=[0,-1,0]
    dj=[-1,0,1]
    while len(queue):
        i,j=queue.popleft()
        for k in range(3):
            next_i=i+di[k]
            next_j=j+dj[k]
            if next_i<0 or next_i>=base or next_j<0 or next_j>M-1 or visit[next_i][next_j]!=0:
                continue
            else:
                if constrint+1<=visit[i][j]:
                    return [False,[]]
                else:
                    if world[next_i][next_j]==1:
                        return [True,[next_i,next_j]]
                    else:
                        visit[next_i][next_j]=visit[i][j]+1
                        queue.append([next_i,next_j])
    return [False, []]
max_hunt=0
for arc_pos in combine:
    world=copy.deepcopy(real_world)
    temp_hunt = 0
    for i in range(N, -1, -1):
        hunt_result = [[],[],[]]
        for j in range(3):
            hunt_result[j]=bfs([i,arc_pos[j]],D)
        # print(hunt_result)
        # for a in range(N):
        #     print(*world[a])
        for j in range(3):
            if hunt_result[j][0]:
                if world[hunt_result[j][1][0]][hunt_result[j][1][1]]==1:
                    world[hunt_result[j][1][0]][hunt_result[j][1][1]]=0
                    temp_hunt+=1
    max_hunt=max(max_hunt,temp_hunt)
    # print(arc_pos)
    # print(max_hunt)

print(max_hunt)