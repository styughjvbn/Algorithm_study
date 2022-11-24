import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)
v,e=map(int,input().split())
parent=[-1 for _ in range(v)]
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
        parent[root_b] += parent[root_b]
        parent[root_a] = root_b
    return True

Edge=[]
for i in range(e):
    a,b,c=map(int,input().split())
    Edge.append([a-1,b-1,c])

Edge.sort(key=lambda a:a[2])

result=0
for i in range(e):
    a,b,c=Edge[i]
    if union(a,b):
        result+=c
print(result)