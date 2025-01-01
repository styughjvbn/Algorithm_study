n=int(input())
if n==1:
    print(3)
else:
    dp=[3,7]
    for i in range(2,n):
        dp.append((dp[i-1]*2+dp[i-2])%9901)
    print(dp[-1])