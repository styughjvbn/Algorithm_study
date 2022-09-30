import sys
from collections import deque

n,m=map(int,sys.stdin.readline().split())
real_map=[]
red_pos=[]
blue_pos=[]
for i in range(n):
    temp=list(sys.stdin.readline().strip())
    for j in range(m):
        if temp[j]=='R':
            red_pos=[i,j]
        elif temp[j]=='B':
            blue_pos=[i,j]
    real_map.append(temp)

def move(red_pos,blue_pos,dir):
    di=[0,1,0,-1]
    dj=[1,0,-1,0]
    goal_red=0
    goal_blue=0
    next_red_i=red_pos[0]
    next_red_j=red_pos[1]
    next_blue_i = blue_pos[0]
    next_blue_j = blue_pos[1]
    while True:
        next_red_i=next_red_i+di[dir]
        next_red_j = next_red_j+dj[dir]
        if real_map[next_red_i][next_red_j]=='#':
            next_red_i = next_red_i - di[dir]
            next_red_j = next_red_j - dj[dir]
            break
        elif real_map[next_red_i][next_red_j]=='O':
            goal_red=1
            break
    while True:
        next_blue_i = next_blue_i+di[dir]
        next_blue_j = next_blue_j+dj[dir]
        if real_map[next_blue_i][next_blue_j]=='#':
            next_blue_i = next_blue_i - di[dir]
            next_blue_j = next_blue_j - dj[dir]
            break
        elif real_map[next_blue_i][next_blue_j]=='O':
            goal_blue=1
            break
    if goal_blue:
        return [],[],-1
    if goal_red:
        return [],[],0
    if dir%2==0:
        if next_red_i==next_blue_i and next_red_j==next_blue_j:
            if abs(red_pos[1]-next_red_j)>abs(blue_pos[1]-next_blue_j):
                next_red_j=next_red_j-dj[dir]
            else:
                next_blue_j = next_blue_j - dj[dir]
    else:
        if next_red_i==next_blue_i and next_red_j==next_blue_j:
            if abs(red_pos[0]-next_red_i)>abs(blue_pos[0]-next_blue_i):
                next_red_i=next_red_i-di[dir]
            else:
                next_blue_i = next_blue_i - di[dir]
    return [next_red_i,next_red_j],[next_blue_i,next_blue_j],1

visit=[[[[0 for _ in range(m)]for _ in range(n)]for _ in range(m)]for _ in range(n)]
queue=deque()
queue.append([red_pos,blue_pos])
visit[red_pos[0]][red_pos[1]][blue_pos[0]][blue_pos[1]]=1
while len(queue):
    cur_red_pos,cur_blue_pos=queue.popleft()
    for i in range(4):
        chk_red,chk_blue,flag=move(cur_red_pos,cur_blue_pos,i)
        if flag==1:
            if visit[chk_red[0]][chk_red[1]][chk_blue[0]][chk_blue[1]]==0:
                visit[chk_red[0]][chk_red[1]][chk_blue[0]][chk_blue[1]]=visit[cur_red_pos[0]][cur_red_pos[1]][cur_blue_pos[0]][cur_blue_pos[1]]+1
                queue.append([chk_red,chk_blue])
        elif flag==0:
            if visit[cur_red_pos[0]][cur_red_pos[1]][cur_blue_pos[0]][cur_blue_pos[1]]<=10:
                print(visit[cur_red_pos[0]][cur_red_pos[1]][cur_blue_pos[0]][cur_blue_pos[1]])
                exit()
            else:
                print(-1)
                exit()
print(-1)
