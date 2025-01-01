import sys
from collections import deque
#파이썬의 collections 모듈을 이용하면 더욱 간단하게 구현가능..@
n=int(sys.stdin.readline().strip())


for i in range(n):
    m,k=map(int,sys.stdin.readline().split())
    arr=list(map(int,sys.stdin.readline().split()))
    queue1 = deque(arr)
    queue2 = deque(list(range(m)))
    count = 1
    while True:
        if queue1[0]<max(queue1):
            queue1.append(queue1.popleft())
            queue2.append(queue2.popleft())
        else:
            if(queue2.popleft()==k):
                print(count)
                break
            queue1.popleft()
            count += 1
