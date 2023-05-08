import sys
from collections import deque
from itertools import combinations
input=sys.stdin.readline
n,m=map(int,input().split())

room=[]
virus=[]
empty_num=0
for i in range(n):
    line=list(map(int,input().split()))
    for j in range(n):
        if line[j]==2:
            virus.append([i,j])
        if line[j]!=1:
            empty_num+=1
    room.append(line)
virus_case=list(combinations(virus,m))

di=[0,1,0,-1]
dj=[1,0,-1,0]
result=10**10
if empty_num-len(virus)==0:
    print(0)
    exit()
for i in range(len(virus_case)):
    queue=deque()
    visit=[[0 for _ in range(n)]for _ in range(n)]
    for j in range(m):
        queue.append(virus_case[i][j])
        visit[virus_case[i][j][0]][virus_case[i][j][1]]=1
    max_sec=0
    empty_count=empty_num-len(virus)
    while queue:
        if max_sec>=result and empty_count==0:
            break
        a,b=queue.popleft()
        for k in range(4):
            na=a+di[k]
            nb=b+dj[k]
            if na>=n or nb>=n or na<0 or nb<0 or room[na][nb]==1:
                continue
            else:
                if visit[na][nb]==0:
                    visit[na][nb]=1+visit[a][b]
                    queue.append([na,nb])
                    if room[na][nb] != 2:
                        empty_count-=1
                        max_sec = max(max_sec, visit[na][nb])
    if empty_count==0:
        result=min(result,max_sec)
        # if max_sec == 6:
        #     for i in range(n):
        #         print(*visit[i])
if result!=10**10:
    print(result-1)
else:
    print(-1)