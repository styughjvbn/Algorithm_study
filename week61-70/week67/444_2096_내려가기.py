import sys
input=sys.stdin.readline

n=int(input())

max_dp=list(map(int,input().split()))
min_dp=[*max_dp]
for i in range(n-1):
    nums=list(map(int,input().split()))
    max_temp=[*max_dp]
    max_dp[0]=nums[0]+max(max_temp[0],max_temp[1])
    max_dp[1]=nums[1]+max(max_temp[0],max_temp[1],max_temp[2])
    max_dp[2]=nums[2]+max(max_temp[1],max_temp[2])
    min_temp=[*min_dp]
    min_dp[0]=nums[0]+min(min_temp[0],min_temp[1])
    min_dp[1]=nums[1]+min(min_temp[0],min_temp[1],min_temp[2])
    min_dp[2]=nums[2]+min(min_temp[1],min_temp[2])
print(max(max_dp),min(min_dp))