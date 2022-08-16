import sys

n=int(sys.stdin.readline().strip())
arr=[0]*n
dp=[0]*n
for i in range(n):
    arr[i]=int(sys.stdin.readline().strip())

dp[0]=arr[0]
if n>1:
    dp[1]=arr[0]+arr[1]
if n>2:
    dp[2]=max(arr[0]+arr[2],arr[1]+arr[2])
for i in range(3,n):
    dp[i]=arr[i]+max(dp[i-2],arr[i-1]+dp[i-3])

print(dp[-1])


