import sys
from collections import deque

n,k=map(int,sys.stdin.readline().split())
temp=list(map(int,sys.stdin.readline().split()))
robot_pos=[0]*n
up=deque(temp[:n])
down=deque(reversed(temp[n:]))
iter=0
while True:
    iter+=1
    up.appendleft(down.popleft())
    down.append(up.pop())
    robot_pos=[0]+robot_pos[:-1]
    robot_pos[-1]=0
    for i in range(n-2,-1,-1):
        if robot_pos[i]==1:
            if up[i+1]!=0 and robot_pos[i+1]==0:
                robot_pos[i] = 0
                up[i + 1] = up[i + 1] - 1
                if i + 1 != n - 1:
                    robot_pos[i+1]=1
    if up[0]!=0:
        robot_pos[0]=1
        up[0]=up[0]-1
    sum=0
    for i in range(n):
        if up[i]<=0:
            sum+=1
    for i in range(n):
        if down[i]<=0:
            sum+=1
    if sum>=k:
        print(iter)
        break

