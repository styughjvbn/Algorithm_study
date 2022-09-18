import sys
from collections import deque
import copy

n,m=map(int,sys.stdin.readline().split())

mage=[0]*n
zeros=0
load=[]
virus=[]
for i in range(n):
    line=list(map(int,sys.stdin.readline().split()))
    mage[i] = line
    for j in range(m):
        if line[j]==0:
            zeros+=1
            load.append([i,j])
        if line[j]==2:
            virus.append([i,j])

di=[0,1,0,-1]
dj=[1,0,-1,0]
max_zero=0
for a in range(len(load)):
    for b in range(a+1,len(load)):
        for c in range(b+1,len(load)):
            temp_mage = copy.deepcopy(mage)
            temp_mage[load[a][0]][load[a][1]] = 1
            temp_mage[load[b][0]][load[b][1]] = 1
            temp_mage[load[c][0]][load[c][1]] = 1
            queue=deque(virus)
            current_zero = zeros-3
            flag=False
            while len(queue):
                i,j=queue.popleft()
                for k in range(4):
                    next_i=i+di[k]
                    next_j = j + dj[k]
                    if next_i>n-1 or next_i<0 or next_j>m-1 or next_j<0:
                        continue
                    else:
                        if temp_mage[next_i][next_j]==0:
                            temp_mage[next_i][next_j] = 2
                            current_zero-=1
                            if current_zero<max_zero:
                                flag=True
                            queue.append([next_i,next_j])
                if flag:
                    break
            max_zero=max(max_zero,current_zero)

print(max_zero)