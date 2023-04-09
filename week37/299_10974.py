from itertools import permutations

n=int(input())
nums=[i for i in range(1,n+1)]
permu=list(permutations(nums,n))
permu.sort()
for i in permu:
    print(*i)