import sys
import heapq
#파이썬의 내부 모듈을 활용
#heapq 모듈에서 push요소로 튜플을 전달할수 있다. (우선순위, 작업)의 쌍으로 넣어준다.
n=int(sys.stdin.readline().strip())
heap=[]

for i in range(n):
    oper=int(sys.stdin.readline().strip())
    if oper==0:
        if len(heap)==0:
            print(0)
        else:
            print(heapq.heappop(heap)[1])
    else:
        heapq.heappush(heap,(abs(oper),oper))

