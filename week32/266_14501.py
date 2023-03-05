import sys
input=sys.stdin.readline

N=int(input())
schedule=[]
for i in range(N):
    t,p=map(int,input().split())
    schedule.append([t,p])

dp=[0 for _ in range(N+1)]

for i in range(N):
    for j in range(i+schedule[i][0],N+1):
        if dp[j]<dp[i]+schedule[i][1]:
            dp[j] = dp[i] + schedule[i][1]

print(dp[-1])