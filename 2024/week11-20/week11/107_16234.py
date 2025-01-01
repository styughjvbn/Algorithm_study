import sys
from collections import deque

N,L,R=map(int,sys.stdin.readline().split())
population=[]
for i in range(N):
    population.append(list(map(int,sys.stdin.readline().split())))

di=[0,1,0,-1]
dj=[1,0,-1,0]
result=0
for days in range(2001):
    visit = [[0 for _ in range(N)] for _ in range(N)]
    count=0
    for b in range(N):
        for c in range(N):
            if visit[b][c]==0:
                queue = deque()
                queue.append([b, c])
                visit[b][c]=1
                group=[]
                group.append([b, c])
                while len(queue):
                    i,j=queue.popleft()
                    for k in range(4):
                        next_i=i+di[k]
                        next_j=j+dj[k]
                        if next_i>-1 and next_i<N and next_j>-1 and next_j<N and visit[next_i][next_j]==0:
                            if abs(population[i][j]-population[next_i][next_j])>=L and abs(population[i][j]-population[next_i][next_j])<=R:
                                group.append([next_i,next_j])
                                visit[next_i][next_j]=1
                                queue.append([next_i,next_j])
                if len(group):
                    sum=0
                    for a in group:
                        sum+=population[a[0]][a[1]]
                    sum=sum//len(group)
                    for a in group:
                        population[a[0]][a[1]]=sum
                if len(group)>1:
                    count+=1

    if count:
        result+=1
    else:
        print(result)
        break


