import sys

n=int(sys.stdin.readline().strip())
arr=list(map(int,sys.stdin.readline().split()))

dp=[1]*n

for i in range(n):
    max1=0
    for j in range(i):
        if arr[j]>arr[i] and dp[j]>max1:
            max1=dp[j]
    dp[i]=max1+1

print(max(dp))