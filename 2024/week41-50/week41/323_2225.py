n,k=map(int,input().split())

dp=[[1 for _ in range(n+1)]for _ in range(k)]
for i in range(1,k):
    for j in range(1,n+1):
        dp[i][j]=dp[i-1][j]+dp[i][j-1]
print(dp[k-1][n]%1000000000)