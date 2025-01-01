import sys
sys.setrecursionlimit(10 ** 6)

n,m,r=map(int,sys.stdin.readline().split())
v=[0 for i in range(n+1)]
e=[[] for i in range(n+1)]

for i in range(1,m+1):
    start,end=map(int,sys.stdin.readline().split())
    e[start].append(end)
    e[end].append(start)
a=1
def dfs(num):
    global v
    global e,a

    if v[num]!=0:
        return
    else:
        v[num] = a
        a=a+1
        e[num].sort(reverse=True)
        for j in e[num]:
            dfs(j)

dfs(r)

for i in range(1,n+1):
    print(v[i])
