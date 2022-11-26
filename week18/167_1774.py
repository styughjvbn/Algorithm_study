import math
import sys
from itertools import combinations

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

input=sys.stdin.readline
result=0
n,m=map(int,input().split())
parents=[-1 for i in range(n)]

stars=[]
for i in range(n):
    a,b=map(int,input().split())
    stars.append([a,b])
lines=[]
for i in range(m):
    a,b=map(int,input().split())
    union(a-1,b-1)

comb=list(combinations([i for i in range(n)],2))
edge=[]
point=0
for i in range(len(comb)):
    edge.append([math.sqrt(math.pow((stars[comb[i][1]][0]-stars[comb[i][0]][0]),2)+math.pow((stars[comb[i][1]][1]-stars[comb[i][0]][1]),2)),comb[i][0],comb[i][1]])
edge.sort()

for i in range(len(edge)):
    if union(edge[i][1],edge[i][2]):
        result+=edge[i][0]
print(format(result,".2f"))