import sys
import heapq
input=sys.stdin.readline
n=int(input())
nums=[]
for i in range(n):
    temp=input().split()
    for j in range(n):
        if len(nums)<n:
            heapq.heappush(nums,int(temp[j]))
        else:
            heapq.heappushpop(nums,int(temp[j]))
print(nums[0])