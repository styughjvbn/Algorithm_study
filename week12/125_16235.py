import sys
from collections import deque
import heapq

N,M,K=map(int,sys.stdin.readline().split())
ground=[[0for _ in range(N)]for _ in range(N)]
for i in range(N):
    additional_nut=list(map(int,sys.stdin.readline().split()))
    for j in range(N):
        ground[i][j]=[5,additional_nut[j],[],[]]
for i in range(M):
    tree_pos=list(map(int,sys.stdin.readline().split()))
    heapq.heappush(ground[tree_pos[0]-1][tree_pos[1]-1][2],tree_pos[2])
di=[0,1,1,1,0,-1,-1,-1]
dj=[1,1,0,-1,-1,-1,0,1]

for a in range(K):
    # print("----------------------------",a,"년차 시작")
    # for i in range(N):
    #     for j in range(N):
    #         print(ground[i][j], end="  ")
    #     print()

    for i in range(N):
        for j in range(N):
            ground[i][j][2].sort()
            for k in range(len(ground[i][j][2])):

                if ground[i][j][0]-ground[i][j][2][k]>=0:
                    ground[i][j][0]=ground[i][j][0]-ground[i][j][2][k]
                    ground[i][j][2][k]+=1
                else:
                    for b in range(k,len(ground[i][j][2])):
                        ground[i][j][0]+=(ground[i][j][2][b])//2
                    ground[i][j][2]=ground[i][j][2][:k]
                    break
    # print("----------------------------", a, "년차 여름 끝")
    # for i in range(N):
    #     for j in range(N):
    #         print(ground[i][j], end="  ")
    #     print()
    for i in range(N):
        for j in range(N):
            ground[i][j][0] += ground[i][j][1]
            for k in range(len(ground[i][j][2])):
                if ground[i][j][2][k]%5==0:
                    for q in range(8):
                        next_i=i+di[q]
                        next_j = j + dj[q]
                        if next_i>-1 and next_i<N and next_j>-1 and next_j<N:
                            ground[next_i][next_j][2].append(1)
    # print("----------------------------", a, "년차 끝")
    # for i in range(N):
    #     for j in range(N):
    #         print(ground[i][j],end="  ")
    #     print()

result=0
for i in range(N):
    for j in range(N):
        result+=len(ground[i][j][2])
print(result)