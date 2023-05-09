import sys
input=sys.stdin.readline

n,m=map(int,input().split())
graph=[[]for _ in range(n+1)]
degree=[0 for _ in range(n+1)]
for i in range(m):
    a,b=map(int,input().split())
    graph[a].append(b)
    degree[b]+=1
temp=[]
for  i in range(1,n+1):
    if degree[i]==0:
       temp.append(i)
result=[]
while temp:
    number=temp.pop()
    result.append(number)
    for i in graph[number]:
        degree[i]-=1
        if degree[i]==0:
            temp.append(i)


for i in range(n):
    print(result[i],end=" ")