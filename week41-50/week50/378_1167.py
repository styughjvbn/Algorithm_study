import sys

input=sys.stdin.readline

n=int(input())
vertex=[[] for _ in range(n)]
for i in range(n):
    line=list(map(int,input().split()))
    for j in range(2,len(line),2):
        vertex[line[0]-1].append([line[j-1]-1,line[j]])
result=[0,0]
def dfs(node,dist,start_point):
    global result
    for i in vertex[node]:
        if start_point!=i[0]:
            dfs(i[0],dist+i[1],node)
    if result[0]<dist:
        result=[dist,node]

dfs(0,0,-1)
dfs(result[1],0,-1)
print(result[0])