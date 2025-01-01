import sys
from collections import deque
input=sys.stdin.readline

stack=deque()
n=int(input())
tower_height=list(map(int,input().split()))
result=[0]*(n+1)
tower_height=[10**9]+tower_height
stack.append(0)
for i in range(1,len(tower_height)):
    while True:
        if tower_height[i]<=tower_height[stack[-1]]:
            result[i]=stack[-1]
            stack.append(i)
            break
        else:
            stack.pop()

for i in range(1,n+1):
    print(result[i],end=" ")