import heapq
import sys

input=sys.stdin.readline

n=int(input())
queue=[]
for i in range(n):
    heapq.heappush(queue,int(input()))

result=0
while len(queue)>1:
    a=heapq.heappop(queue)
    b=heapq.heappop(queue)
    result+=a+b
    heapq.heappush(queue,a+b)

print(result)
