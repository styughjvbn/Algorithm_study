from collections import deque
n,k=map(int,input().split())


queue=deque()
queue.append([n,0])
visit=[0]*100001
while queue:
    n_pos,count=queue.popleft()
    if visit[n_pos]:
        continue
    if n_pos==k:
        print(count)
        break
    if n_pos-1>=0:
        queue.append([n_pos-1,count+1])
    if n_pos+1<=100000:
        queue.append([n_pos+1,count+1])
    if n_pos*2<=100000:
        queue.append([n_pos*2,count+1])
    visit[n_pos]=1
