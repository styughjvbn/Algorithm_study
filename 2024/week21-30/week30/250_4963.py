import sys
from collections import deque

input=sys.stdin.readline

dx=[1,1,0,-1,-1,-1,0,1]
dy=[0,1,1,1,0,-1,-1,-1]
while True:
    w,h=map(int,input().split())
    result=0
    if w==0 and h==0:
        break
    else:
        world=[]
        for i in range(h):
            line=list(map(int,input().split()))
            world.append(line)

        visit=[[0 for _ in range(w)]for _ in range(h)]
        for i in range(h):
            for j in range(w):
                if visit[i][j]==0 and world[i][j]==1:
                    queue = deque()
                    queue.append([i,j])
                    visit[i][j]=1
                    while queue:
                        a,b=queue.popleft()
                        for k in range(8):
                            next_a=a+dy[k]
                            next_b=b+dx[k]
                            if next_a>=h or next_a<0 or next_b>=w or next_b<0 or visit[next_a][next_b]==1 or world[next_a][next_b]==0:
                                continue
                            else:
                                visit[next_a][next_b]=1
                                queue.append([next_a,next_b])

                    result+=1
        print(result)

