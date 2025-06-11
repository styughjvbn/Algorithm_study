import sys

input = sys.stdin.readline

n, m = map(int,input().split())
costs = [list(map(int,input().split())) for _ in range(n)]

for i in range(n):
    costs[i][i] = 0
    for j in range(n):
        for k in range(n):
            costs[j][k] = min(costs[j][k], costs[j][i]+costs[i][k])

for _ in range(m):
    a,b,c = map(int,input().split())
    if costs[a-1][b-1] <= c:
        print("Enjoy other party")
    else:
        print("Stay here")