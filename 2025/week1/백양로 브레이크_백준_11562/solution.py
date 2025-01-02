import sys
from collections import deque

input = sys.stdin.readline

n,m = map(int,input().split())

dp = [[500 for _ in range(n)] for _ in range(n)]

for _ in range(m):
    u,v,b=map(lambda a:int(a)-1, input().split())
    dp[u][v] = 0
    dp[v][u] = b*-1

for i in range(n):
    dp[i][i] = 0
    for j in range(n):
        for q in range(n):
            dp[j][q] = min(dp[j][q], dp[j][i]+dp[i][q])

k = int(input())
for _ in range(k):
    s,e = map(lambda a: int(a)-1, input().split())
    print(dp[s][e])

