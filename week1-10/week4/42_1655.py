import sys
import heapq
#중간값보다 큰 값은 최소힙으로, 작은 값은 최대힙으로 따로 관리
#중간값은 항상 최대힙의 루트값으로 관리
n=int(sys.stdin.readline().strip())

leftheap=[]
rightheap=[]

for i in range(n):
    oper=int(sys.stdin.readline().strip())
    if len(leftheap)==len(rightheap):
        heapq.heappush(leftheap,-oper)
    else:
        heapq.heappush(rightheap,oper)
    if len(leftheap)>0 and len(rightheap):
        if -leftheap[0]>rightheap[0]:
            tmp1=-heapq.heappop(leftheap)
            tmp2=heapq.heappop(rightheap)
            heapq.heappush(rightheap,tmp1)
            heapq.heappush(leftheap,-tmp2)
    print(-leftheap[0])