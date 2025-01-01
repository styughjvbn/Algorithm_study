import sys
sys.setrecursionlimit(10**6)
input=sys.stdin.readline

t=int(input())

def dfs(a):
    global result
    if visit[a]!=0:
        return
    else:
        visit[a] = 1
        result+=1
        for i in range(len(graph[a])):
            dfs(graph[a][i])
result=0
for i in range(t):
    result = 0
    n,m=map(int,input().split())
    graph=[[]for _ in range(n)]
    visit=[0for i in range(n)]
    for j in range(m):
        a,b=map(int,input().split())
        graph[a-1].append(b-1)
        graph[b-1].append(a-1)
    dfs(0)
    print(result-1)
