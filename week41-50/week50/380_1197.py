import sys

input=sys.stdin.readline

v,e=map(int,input().split())

vertex=[-1 for _ in range(v)]
def union(a,b):
    root_a=find(a)
    root_b=find(b)
    if root_a==root_b:
        return False
    else:
        if vertex[root_a]>vertex[root_b]:
            vertex[root_b]+=vertex[root_a]
            vertex[root_a]=root_b
        else:
            vertex[root_a] += vertex[root_b]
            vertex[root_b] = root_a
        return True

def find(a):
    if vertex[a]<0:
        return a
    else:
        return find(vertex[a])

edge=[list(map(int,input().split())) for _ in range(e)]
edge.sort(key=lambda a:a[2])

result=0
for i in edge:
    if union(i[0]-1,i[1]-1):
        result+=i[2]
print(result)