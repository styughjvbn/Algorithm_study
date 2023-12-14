import sys
from collections import deque
input=sys.stdin.readline

def print_arr(arr):
    for i in range(len(arr)):
        print(*arr[i])
    print("========================")

"$".isalpha()
k=int(input())
di=[0,1,0,-1]
dj=[1,0,-1,0]
for _ in range(k):
    result=0
    h,w=map(int,input().split())
    doors=[[0,0,0,[]] for _ in range(26)]# 0 - 접근 가능 유무 , 1 - 키 소유 유무, 2 - 개문 여부, 3 - 문 위치
    building=[["." for _ in range(w+2)]]
    for i in range(h):
        line=['.']+list(input())+['.']
        # for j in range(w+2):
        #     if line[j].isalpha():
        #         if line[j].isupper():
        #             doors[ord(line[j])-65][3].append((i,j))
        building.append(line)
    building.append(["." for _ in range(w+2)])
    keys=input().strip()
    if keys!="0":
        for i in keys:
            doors[ord(i)-97][1]=1
    visit=[[0 for _ in range(w+2)] for _ in range(h+2)]
    queue=deque()
    queue.append([0,0])
    visit[0][0]=1
    while queue:
        while queue:
            i,j=queue.popleft()
            for k in range(4):
                ni=i+di[k]
                nj=j+dj[k]
                if 0<=ni<h+2 and 0<=nj<w+2 and visit[ni][nj]==0 and building[ni][nj]!="*":
                    visit[ni][nj]=1
                    if building[ni][nj].isalpha():
                        if building[ni][nj].isupper():
                            doors[ord(building[ni][nj])-65][0]=1 #접근 가능 체크
                            doors[ord(building[ni][nj])-65][3].append((ni,nj))
                        else:
                            doors[ord(building[ni][nj])-97][1]=1 #키 획득 체크
                            queue.append([ni,nj])
                    else:
                        if building[ni][nj]=="$":
                            result+=1
                        queue.append([ni,nj])
        # print_arr(visit)
        for door in doors:
            if door[1]==1:
                while door[3]:
                    queue.append(door[3].pop())

    print(result)