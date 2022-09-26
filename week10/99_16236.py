import sys
from collections import deque

n=int(sys.stdin.readline())

fishbowl=[0]*n
fishposition=[0,0]
fishsize=2
fisheat=0
result=0
for i in range(n):
    temp=list(map(int,sys.stdin.readline().split()))
    for j in range(n):
        if temp[j] == 9:
            fishposition=[i,j]
        fishbowl[i]=temp

def bfs():
    global fisheat
    global fishsize
    global fishposition
    global result
    queue=deque()
    queue.append(fishposition)
    di=[0,1,0,-1]
    dj=[1,0,-1,0]
    distance=[[-1 for _ in range(n)]for _ in range(n)]
    distance[fishposition[0]][fishposition[1]]=0
    ediblefish=[]
    flag=0
    while len(queue):
        i,j=queue.popleft()

        for k in range(4):
            next_i=i+di[k]
            next_j=j+dj[k]
            if next_i<0 or next_i>=n or next_j<0 or next_j>=n or fishbowl[next_i][next_j]>fishsize:
                continue
            else:
                if distance[next_i][next_j]==-1:
                    queue.append([next_i,next_j])
                    distance[next_i][next_j]=distance[i][j]+1
                    if fishbowl[next_i][next_j]<fishsize and fishbowl[next_i][next_j]>0:
                        ediblefish.append([next_i,next_j,distance[next_i][next_j]])

    if len(ediblefish)==0:
        return 0
    ediblefish.sort(key=lambda a: a[1])
    ediblefish.sort( key=lambda a: a[0])
    ediblefish.sort(key=lambda a: a[2])
    fishbowl[fishposition[0]][fishposition[1]] = 0
    fishposition=ediblefish[0][:2]
    fishbowl[fishposition[0]][fishposition[1]]=9
    result+=distance[fishposition[0]][fishposition[1]]
    fisheat+=1
    if fisheat==fishsize:
        fishsize+=1
        fisheat=0


while True:
    if bfs()==0:
        print(result)
        break