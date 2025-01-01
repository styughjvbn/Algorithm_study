n=int(input())
dp=[0]*(n+1)
dp_list=[[] for _ in range(n+1)]
for i in range(2,n+1):
    min_dp=i-1
    if  i%2==0 and dp[min_dp]> dp[i//2]:
        min_dp=i//2
    if i%3==0 and dp[min_dp]>dp[i//3]:
        min_dp=i//3
    dp[i]=dp[min_dp]+1
    dp_list[i]=dp_list[min_dp]+[i]
print(dp[n])
for i in range(dp[n]-1,-1,-1):
    print(dp_list[n][i],end=" ")
print("1")