import sys
input=sys.stdin.readline
t=int(input())

def find(x):
    if type(parent[x])==int:
        return x
    else:
        y=find(parent[x])
        parent[x]=y
        return y

def union(a,b):
    root_a=find(a)
    root_b = find(b)
    if root_a==root_b:
        return
    if root_a<root_b:
        parent[root_a]+=parent[root_b]
        parent[root_b]=root_a
    else:
        parent[root_b] += parent[root_a]
        parent[root_a] = root_b

parent = {}

for _ in range(t):
    n= int(input())
    parent = {}
    for i in range(n):
        per1,per2=input().split()
        if per1 not in parent:
            parent[per1]=-1
        if per2 not in parent:
            parent[per2]=-1
        union(per1,per2)
        print(-parent[find(per1)])