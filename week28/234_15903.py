import sys,heapq

input=sys.stdin.readline

n,m=map(int,input().split())
heap=list(map(int,input().split()))
heapq.heapify(heap)

for i in range(m):
    num1=heapq.heappop(heap)
    num2 = heapq.heappop(heap)
    heapq.heappush(heap,num1+num2)
    heapq.heappush(heap, num1 + num2)

print(sum(heap))
