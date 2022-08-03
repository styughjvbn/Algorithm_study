import sys
from collections import deque

t=int(sys.stdin.readline().strip())
#deque로 구현하되 O(n)인 reverse를 최대한 줄인다.
#R이 연속으로 짝수번 나온다면 R를 하지 않을 때와 똑같다.
for j in range(t):
    oper=sys.stdin.readline().strip()
    num=int(sys.stdin.readline().strip())
    arr = sys.stdin.readline().strip()
    if num>0:
        arr=deque(arr[1:len(arr)-1].split(','))
    else:
        arr=deque()
    error=False
    flag=0
    for i in oper:
        if i=='R':
            flag+=1
        elif i=='D':
            if(len(arr)>0):
                if flag%2==0:
                    arr.popleft()
                else:
                    arr.pop()
            else:
                error=True
                break
    if error:
        print('error')
    else:
        if flag % 2 == 0:
            print('[' + ",".join(arr) + ']')
        else:
            arr.reverse()
            print('[' + ",".join(arr) + ']')