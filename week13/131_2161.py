import sys
from collections import deque
n=int(sys.stdin.readline())
temp=[i for i in range(1,n+1)]
queue=deque(temp)
while len(queue)>1:
    print(queue.popleft(),end=" ")
    queue.append(queue.popleft())
print(queue[0])


