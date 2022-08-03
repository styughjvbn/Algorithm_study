import sys
from collections import deque
import math

# 인덱스에 따른 회전 방향 제어
n,m=map(int,sys.stdin.readline().split())
arr=list(map(int,sys.stdin.readline().split()))
my_queue=deque(list(range(1,n+1)))

count=0
num=0
while num<m:
    if my_queue[0]==arr[num]:

        my_queue.popleft()
        num+=1

    else:
        if math.ceil(len(my_queue) /2)<=my_queue.index(arr[num]):
            my_queue.rotate(1)
        else:
            my_queue.rotate(-1)
        count+=1

print(count)