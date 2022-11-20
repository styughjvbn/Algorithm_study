import sys
input=sys.stdin.readline

n=int(input())
parent=[-1 for _ in range(n+1)]
m=int(input())
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
        return
    if parent[root_a]<parent[root_b]:
        parent[root_a]+=parent[root_b]
        parent[root_b]=root_a
    else:
        parent[root_b] += parent[root_a]
        parent[root_a] = root_b

for i in range(1,n+1):
    arr=list(map(int,input().split()))
    for j in range(len(arr)):
        if arr[j]:
            union(i,j+1)

travle=list(map(int,input().split()))
root=find(travle[0])
for i in range(1,m):
    if root!=find(travle[i]):
        print("NO")
        exit()
print("YES")
