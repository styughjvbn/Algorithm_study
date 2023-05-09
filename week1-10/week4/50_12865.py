import sys
#대표적인 배낭문제!
n,k=map(int,sys.stdin.readline().split())
arr=[]
for i in range(n):
    arr.append(list(map(int,sys.stdin.readline().split())))

dp=[[0 for _ in range(k+1)] for _ in range(n+1)]

for i in range(1,n+1):
    for j in range(1,k+1):
        index = j - arr[i-1][0]
        if index<0:
            dp[i][j]=dp[i-1][j]
        else:
            dp[i][j]=max(arr[i-1][1]+dp[i-1][index],dp[i-1][j])

print(dp[n][k])