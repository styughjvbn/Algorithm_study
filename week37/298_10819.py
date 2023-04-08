from itertools import permutations

n=int(input())
nums=list(map(int,input().split()))
result=0
num_case=permutations(nums,n)
for i in list(num_case):
    n_sum=0
    for j in range(len(i)-1):
        n_sum+=abs(i[j]-i[j+1])
    result=max(result,n_sum)

print(result)