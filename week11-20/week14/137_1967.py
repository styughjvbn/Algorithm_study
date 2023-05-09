import sys
sys.setrecursionlimit(10**6)
n=int(sys.stdin.readline())
graph=[[]for _ in range(n+1)]

for i in range((n-1)):
    temp = list(map(int, sys.stdin.readline().split()))
    graph[temp[0]].append([temp[1],temp[2]])
    graph[temp[1]].append([temp[0], temp[2]])

visit=[0]*(n+1)
resut=[1,0]
def dfs(num,add):
    global resut
    for a,b in graph[num]:
        if visit[a]==0:
            visit[a]=1
            dfs(a,add+b)
            visit[a]=0
    if resut[1]<add:
        resut[1]=add
        resut[0]=num

visit[1]=1
dfs(1,0)
visit[1]=0
visit[resut[0]]=1
dfs(resut[0],0)
visit[resut[0]]=0
print(resut[1])