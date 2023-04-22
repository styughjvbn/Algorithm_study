n=int(input())
dp=[[] for _ in range(n)]
dp[0]=[1,1]
for i in range(1,n):
    dp[i]=[(dp[i-1][0]+dp[i-1][1]*2)%9901,(dp[i-1][0]+dp[i-1][1])%9901]
print((dp[n-1][0]+dp[n-1][1]*2)%9901)