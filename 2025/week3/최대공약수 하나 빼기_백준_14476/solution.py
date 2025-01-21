import sys

def 최대공약수구하기(a, b):
    if a < b:
        a,b = b,a
    if a == b:
        return a
    while b>0:
        temp = a%b
        a = b
        b = temp
    return a

input = sys.stdin.readline

n = int(input())
nums = list(map(int,input().split()))
prefix = [nums[0]]
suffix = [nums[-1]]
for idx in range(n-1):
    prefix.append(최대공약수구하기(prefix[-1], nums[idx+1]))
    suffix.append(최대공약수구하기(suffix[-1], nums[-(idx+2)]))
# print(prefix)
# print(suffix)
result = (-1, 0)
if nums[-1] % prefix[-2] != 0:
    if result[0] < prefix[-2]:
        result = (prefix[-2], nums[-1])
if nums[0] % suffix[-2] != 0:
    if result[0] < suffix[-2]:
        result = (suffix[-2], nums[0])
for idx in range(1, n-1):
    최대공약수 = 최대공약수구하기(prefix[idx-1], suffix[-(idx+2)])
    if nums[idx] % 최대공약수 != 0:
        if result[0] < 최대공약수:
            result = (최대공약수, nums[idx])
print(result[0], end=" ")
print(result[1] if result[0]!=-1 else "")