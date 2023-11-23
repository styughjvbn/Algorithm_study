from collections import deque

def solution(n, paths, gates, summits):
    answer = [n+1,10000001]

    temp=[[] for _ in range(n)]
    for i,j,w in paths:
        temp[i-1].append([j-1,w])
        temp[j-1].append([i-1,w])

    node_type=[0]*n
    min_intensity=[0]*n
    for i in gates:
        node_type[i-1]=1
        min_intensity[i-1]=0
    for i in summits:
        node_type[i-1]=2

    for i in gates:
        queue=deque()
        queue.append([i-1,0])

        while queue:
            node,length=queue.popleft()
            for j,w in temp[node]:
                if node_type[j]==1:
                    continue
                if min_intensity[j]==0:
                    min_intensity[j]=max(length,w)
                    if node_type[j]!=0 :
                        continue
                    queue.append([j,min_intensity[j]])
                else:
                    if min_intensity[j]>max(length,w):
                        min_intensity[j]=max(length,w)
                        if node_type[j]!=0 :
                            continue
                        queue.append([j,min_intensity[j]])
    summits.sort()
    for i in summits:
        if answer[1]>min_intensity[i-1] and min_intensity[i-1]!=0:
            answer=[i,min_intensity[i-1]]
    return answer