from collections import deque

n,k=map(int,input().split())
visit=[0 for _ in range(100001)]
queue=deque()
queue.append([n,""])
visit[n]=1
if k<n:
    print(n-k)
    for i in range(n,k-1,-1):
        print(i,end=" ")
else:
    while queue:
        num,prev_route=queue.popleft()
        if num==k:
            print(visit[num]-1)
            print(prev_route.strip(),end=" ")
            print(k)
            exit()
        if num+1<=100000:
            if visit[num+1] == 0:
                visit[num+1] = visit[num] + 1
                route=prev_route+" "+str(num)
                queue.append([num+1,route])
        if num-1>=0:
            if visit[num-1] == 0:
                visit[num-1] = visit[num] + 1
                route = prev_route+" "+str(num)
                queue.append([num-1,route])
        if num*2<=100000:
            if visit[num*2]==0:
                visit[num*2]=visit[num]+1
                route = prev_route+" "+str(num)
                queue.append([num*2,route])