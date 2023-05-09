import sys
from collections import deque
#파이썬의 collections 모듈을 이용하면 더욱 간단하게 구현가능..@
n,k=map(int,sys.stdin.readline().split())

result=[]
queue=deque(list(range(1,n+1)))
for i in range(n):
    for j in range(k-1):
        queue.append(queue.popleft())
    result.append(queue.popleft())

print('<'+', '.join(map(str,result))+'>')