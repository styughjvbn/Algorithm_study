import sys
input=sys.stdin.readline

n,m=map(int,input().split())
truth=list(map(int,input().split()))
truth_mans=truth[1:]
parties=[list(map(int,input().split())) for _ in range(m)]
mans=[-1 for _ in range(n)]

for i in range(truth[0]):
    mans[truth[i+1]-1]=-50
def find(a):
    if mans[a]<0:
        return a
    else:
        mans[a]=find(mans[a])
        return mans[a]

def union(a,b):
    root_a=find(a)
    root_b=find(b)
    if root_a==root_b:
        pass
    else:
        if mans[root_a]<mans[root_b]:
            mans[root_a]+=mans[root_b]
            mans[root_b]=root_a
        else:
            mans[root_b]+=mans[root_a]
            mans[root_a]=root_b

for party in parties:
    if len(party)<2:
        continue
    for i in range(party[0]-1):
        union(party[i+1]-1,party[i+2]-1)

result=0
for party in parties:
    for i in range(party[0]):
        if find(party[i+1]-1)+1 in truth_mans:
            break
    else:
        result+=1

print(result)