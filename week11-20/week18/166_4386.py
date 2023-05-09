import math
import sys
from itertools import combinations

input=sys.stdin.readline

n=int(input())
stars=[]
for i in range(n):
    a,b=map(float,input().split())
    stars.append([a,b])

comb=list(combinations([i for i in range(n)],2))
edge=[]
for i in range(len(comb)):
    edge.append([math.sqrt(math.pow((stars[comb[i][1]][0]-stars[comb[i][0]][0]),2)+math.pow((stars[comb[i][1]][1]-stars[comb[i][0]][1]),2)),comb[i][1],comb[i][0]])
edge.sort()
parents=[-1 for i in range(n)]
def find(x):
    if parents[x]<0:
        return x
    else:
        y=find(parents[x])
        parents[x]=y
        return y
def union(a,b):
    root_a=find(a)
    root_b=find(b)
    if root_a==root_b:
        return False
    if parents[root_a]<parents[root_b]:
        parents[root_a]+=parents[root_b]
        parents[root_b]=root_a
    else:
        parents[root_b] += parents[root_a]
        parents[root_a] = root_b
    return True
result=0
for i in range(len(edge)):
    if union(edge[i][1],edge[i][2]):
        result+=edge[i][0]
print((result))