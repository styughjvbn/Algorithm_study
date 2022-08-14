import sys
import heapq
#파이썬의 내부 모듈을 활용
n=int(sys.stdin.readline().strip())
heap=[]

for i in range(n):
    oper=int(sys.stdin.readline().strip())
    if oper==0:
        if len(heap)==0:
            print(0)
        else:
            print(-heapq.heappop(heap))
    else:
        heapq.heappush(heap,-oper)

