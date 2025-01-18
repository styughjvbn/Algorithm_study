import sys

input = sys.stdin.readline

n = int(input())
nums = list(map(int,input().split()))
nums.sort()
result = sum(nums)
totalSum = 0
if n%2 == 0:
    result = max(result, sum(nums[n//2:])*2)
else:
    result = max(result, sum(nums[n//2+1:])*2+nums[n//2])
print(result)