dp=[[0, 0]for _ in range(41)]
dp[0][0]=1
dp[1][1]=1
t=int(input())
for i in range(2,41):
    dp[i]=[dp[i-1][0]+dp[i-2][0],dp[i - 1][1] + dp[i - 2][1]]
for _ in range(t):
    print(*dp[int(input())])