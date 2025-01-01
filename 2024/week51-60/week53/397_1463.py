n=int(input())

dp=[0 for _ in range(10**6+1)]
dp[1]=0
dp[2]=1
dp[3]=1
for i in range(4,10**6+1):
    min_count = dp[i-1]
    if i%2 == 0:
        min_count=min(min_count,dp[i//2])
    if i%3 == 0:
        min_count=min(min_count,dp[i//3])
    dp[i]=min_count+1
print(dp[n])