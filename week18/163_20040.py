import sys
input=sys.stdin.readline

n,m=map(int,input().split())

parent=[-1 for _ in range(n)]

def find(x):
    if parent[x]<0:
        return x
    else:
        y=find(parent[x])
        parent[x]=y
        return y

def union(a,b):
    root_a=find(a)
    root_b=find(b)
    if root_a==root_b:
        return False
    if parent[root_a]<parent[root_b]:
        parent[root_a]+=parent[root_b]
        parent[root_b]=root_a
    else:
        parent[root_b] += parent[root_a]
        parent[root_a] = root_b
    return True


for i in range(m):
    a,b=map(int,input().split())
    temp=union(a,b)
    if not temp:
        print(i+1)
        exit()


print(0)
