import sys
import heapq
input=sys.stdin.readline

n=int(input())
heap_list=[[] for _ in range(1000)]
for i in range(n):
    d,w=map(int,input().split())
    heapq.heappush(heap_list[d-1],-w)
result=0

for i in range(1,1001):
    max_score=[0,1]
    for j in range(1,i+1):
        if len(heap_list[-j]):
            if -heap_list[-j][0] > max_score[0]:
                max_score=[-heap_list[-j][0],-j]
    # print(max_score)
    if max_score[1]<0:
        result+=heapq.heappop(heap_list[max_score[1]])
    # print(max_score,heap_list,result)
    # print()
print(-result)