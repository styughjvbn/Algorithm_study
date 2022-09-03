import sys
from collections import deque

q=int(sys.stdin.readline().strip())
for _ in range(q):
    l=int(sys.stdin.readline().strip())
    start_i,start_j=map(int,sys.stdin.readline().split())
    end_i, end_j = map(int, sys.stdin.readline().split())
    queue=deque()
    queue.append([start_i,start_j])
    visit=[[0 for _ in range(l)]for _ in range(l)]
    visit[start_i][start_j]=1
    di=[-2,-1,1,2,2,1,-1,-2]
    dj=[1,2,2,1,-1,-2,-2,-1]
    while len(queue):
        flag=0
        i,j=queue.popleft()
        for k in range(8):
            tmp_i=i+di[k]
            tmp_j=j+dj[k]
            if tmp_i>=l or tmp_i<0 or tmp_j>=l or tmp_j<0:
                continue
            else:
                if visit[tmp_i][tmp_j]==0:
                    queue.append([tmp_i,tmp_j])
                    visit[tmp_i][tmp_j]=visit[i][j]+1
                    if tmp_i==end_i and tmp_j==end_j:
                        flag=1
            if flag:
                break
        if flag:
            break

    print(visit[end_i][end_j]-1)
