import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)
n,m=map(int,input().split())

parent = [-1 for _ in range(n+1)]
def find(a):
    if parent[a]<0:
        return a
    else:
        b=find(parent[a])
        parent[a]=b
        return b

def union(a,b):
    a_root=find(a)
    b_root=find(b)
    if a_root==b_root:
        return
    if parent[a_root]<parent[b_root]:
        parent[a_root] += parent[b_root]
        parent[b_root]=a_root
    else:
        parent[b_root] += parent[a_root]
        parent[a_root] = b_root

for i in range(m):
    a,b,c=map(int,input().split())
    if a==0:
        union(b,c)
    else:
        if find(b)==find(c):
            print("YES")
        else:
            print("NO")
