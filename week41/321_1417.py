import heapq
n=int(input())
queue=[]
dasom=int(input())
if n==1:
    print(0)
else:
    for i in range(1,n):
        heapq.heappush(queue,-int(input()))
    result=0
    while True:
        num=-heapq.heappop(queue)

        if dasom>num:
            print(result)
            exit()
        else:
            heapq.heappush(queue,-(num-1))
            dasom+=1
            result+=1