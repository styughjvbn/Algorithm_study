import sys
from collections import deque

def bfs(a,b):
    queue = deque()
    queue.append([a,b])
    di=[0,1,0,-1]
    dj=[1,0,-1,0]
    visit[a][b]=1
    temp=[[a,b]]
    while len(queue):
        i,j=queue.popleft()
        for k in range(4):
            next_i=i+di[k]
            next_j=j+dj[k]
            if next_i>=12 or next_i<0 or next_j>=6 or next_j<0 or visit[next_i][next_j]!=0:
                continue
            else:
                if field[next_i][next_j]==field[i][j]:
                    visit[next_i][next_j]=1
                    queue.append([next_i,next_j])
                    temp.append([next_i,next_j])
    if len(temp)>=4:
        return temp
    else:
        return []

def down():
    new_field=[['.' for _ in range(6)]for _ in range(12)]
    visit = [[-1 for _ in range(6)] for _ in range(12)]
    for i in range(6):
        base=11
        for j in range(11,-1,-1):
            if field[j][i]!='.':
                new_field[base][i]=field[j][i]
                visit[base][i]=0
                base-=1
    return new_field,visit


field=[]
visit=[[-1 for _ in range(6)]for _ in range(12)]
result=0
for i in range(12):
    field.append(list(sys.stdin.readline()))
    for j in range(6):
        if field[i][j] != '.':
            visit[i][j] = 0
while True:
    earase = []
    for i in range(11,-1,-1):
        for j in range(6):
            if visit[i][j]==0:
                earase.append(bfs(i,j))
    if len(earase):
        flag=False
        for i in (earase):
            for ei,ej in i:
                field[ei][ej]='.'
                flag = True
        if flag:
            field,visit=down()
            result+=1
        else:
            print(result)
            break
    else:
        print(result)
        break