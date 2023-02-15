import sys
from collections import deque
input=sys.stdin.readline

n=int(input())

world=[]
max_height=0
for i in range(n):
    line=list(map(int,input().split()))
    world.append(line)
    max_height=max(max_height,*line)
result=0
for rain_amount in range(max_height,-1,-1):
    visit=[[0 for _ in range(n)]for _ in range(n)]
    pa=[0,1,0,-1]
    pb=[1,0,-1,0]
    number=0
    for i in range(n):
        for j in range(n):
            if visit[i][j]==0 and world[i][j]>rain_amount:
                queue = deque()
                queue.append([i,j])
                while queue:
                    a,b=queue.popleft()
                    for k in range(4):
                        next_a=a+pa[k]
                        next_b=b+pb[k]
                        if next_a<0 or next_a>=n or next_b<0 or next_b>=n or visit[next_a][next_b]!=0 or world[next_a][next_b]<=rain_amount:
                            continue
                        else:
                            visit[next_a][next_b]=1
                            queue.append([next_a,next_b])
                number+=1
    result=max(result,number)

print(result)