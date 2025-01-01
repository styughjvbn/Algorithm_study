import sys
import heapq
input=sys.stdin.readline

n=int(input())

max_heap=[]
min_heap=[]
num=int(input())
heapq.heappush(min_heap,-num)
print(-min_heap[0])
for i in range(n-1):
    num=int(input())
    if -min_heap[0]>num:
        heapq.heappush(min_heap,-num)
        if len(min_heap)>len(max_heap)+1:
            heapq.heappush(max_heap,-heapq.heappop(min_heap))
    else:
        heapq.heappush(max_heap,num)
        if len(min_heap)<len(max_heap):
            heapq.heappush(min_heap,-heapq.heappop(max_heap))
    # print(min_heap,max_heap)
    print(-min_heap[0])