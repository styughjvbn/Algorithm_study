import sys

input=sys.stdin.readline

n=int(input())

parent=list(map(int,input().split()))
graph=[[] for _ in range(n)]
erase=int(input())
root=0
for i in range(n):
    if parent[i]>=0:
        if i==erase:
            continue
        graph[parent[i]].append(i)
    else:
        root=i

graph[erase]=[]

result=0
def dfs(num):
    global result
    if len((graph[num]))==0:
        if num!=erase:
            result+=1
        return
    else:
        for i in range(len(graph[num])):
            dfs(graph[num][i])
dfs(root)
print(result)