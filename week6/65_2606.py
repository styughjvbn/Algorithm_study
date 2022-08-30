import sys
sys.setrecursionlimit(10 ** 6)

n=int(sys.stdin.readline().strip())
m=int(sys.stdin.readline().strip())
v=[0 for i in range(n+1)]
e=[[] for i in range(n+1)]

for i in range(1,m+1):
    start,end=map(int,sys.stdin.readline().split())
    e[start].append(end)
    e[end].append(start)
a=0
def dfs(num):
    global v
    global e,a

    if v[num]!=0:
        return
    else:
        a = a + 1
        v[num] = a
        e[num].sort()
        for j in e[num]:
            dfs(j)

dfs(1)

print(a-1)
