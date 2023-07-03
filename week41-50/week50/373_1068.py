import sys
from collections import deque

input=sys.stdin.readline

n=int(input())
graph=[[] for _ in range(n)]
tree=map(int,input().split())
del_node=int(input())
root=0
for idx,i in enumerate(tree):
    if i==-1:
        root=idx
    if i!=-1 and idx!=del_node:
        graph[i].append(idx)

result=0
def dfs(node):
    global result
    if len(graph[node])==0:
        result+=1
    else:
        for i in graph[node]:
            dfs(i)
if del_node==root:
    print(0)
else:
    dfs(root)
    print(result)