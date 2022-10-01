import sys
from collections import deque

gears=[]
for i in range(4):
  gears.append(deque(list(map(int,list(sys.stdin.readline().strip())))))

k=int(input())
oper=[]
for i in range(k):
  oper.append(list(map(int,sys.stdin.readline().split())))

temp=[0,0,0,0]
for i,j in oper:
  temp[i-1]=j
  for a in range(i,4):
    if gears[a][-2]!=gears[a-1][2]:
      temp[a] = ((-1)**(a-i +1))*j
    else:
      break
  for a in range(i-2,-1,-1):
    if gears[a+1][-2]!=gears[a][2]:
      temp[a] = (-1)**(i-a+1)*j
    else:
      break
  for a in range(4):
    gears[a].rotate(temp[a])
  temp=[0,0,0,0]
print(gears[0][0]*1+gears[1][0]*2+gears[2][0]*4+gears[3][0]*8)


