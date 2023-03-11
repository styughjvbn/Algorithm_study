import sys

input=sys.stdin.readline

def find(x):
    if computer[x]<0:
        return x
    else:
        computer[x]=find(computer[x])
        return computer[x]

def union(x,y):
    root_x=find(x)
    root_y=find(y)
    if root_x==root_y:
        return False
    else:
        if root_y<root_x:
            computer[root_y]+=computer[root_x]
            computer[root_x]=root_y
        else:
            computer[root_x]+=computer[root_y]
            computer[root_y]=root_x
        return True

N=int(input())
M=int(input())
computer=[-1 for _ in range(N)]
line=[]
for i in range(M):
    a,b,c=map(int,input().split())
    line.append([a,b,c])
line.sort(key=lambda a:a[2])

result=0
for i in range(M):
    a,b,c=line[i]
    if union(a-1,b-1):
        result+=c
print(result)