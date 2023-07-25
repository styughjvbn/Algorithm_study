import heapq
n=int(input())
base=int(input())
if n==1:
    print(0)
    exit()
heap=[]
for i in range(n-1):
    heapq.heappush(heap,-int(input()))

result=0
while True:
    num=-heapq.heappop(heap)
    if base<=num:
        base+=1
        heapq.heappush(heap,-(num-1))
        result+=1
    else:
        print(result)
        exit()