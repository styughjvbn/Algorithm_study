import sys

n,k=map(int,sys.stdin.readline().split())
number=[0]*n
for i in range(n):
    number[i]=int(sys.stdin.readline().strip())

dp=[0 for _ in range(k)]
dp=[1]+dp
for i in range(1,k+1):
    if i%number[0]==0:
        dp[i]=1

for i in range(1,n):
    for j in range(number[i],k+1):
        dp[j]=dp[j]+dp[j-number[i]]

print(dp[-1])