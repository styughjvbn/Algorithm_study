import sys

n,m=map(int,sys.stdin.readline().split())
memory=list(map(int,sys.stdin.readline().split()))
cost=list(map(int,sys.stdin.readline().split()))
result=sum(cost)
dp=[[0 for _ in range(result+1)]for _ in range(n+1)]


for i in range(1,n+1):
    for j in range(sum(cost)+1):
        if(j>=cost[i-1]):
            dp[i][j]=max(memory[i-1]+dp[i-1][j-cost[i-1]],dp[i-1][j])
        else:
            dp[i][j]=dp[i-1][j]
        if dp[i][j]>=m:
            result=min(result,j)

if m != 0:
    print(result)
else:
    print(0)