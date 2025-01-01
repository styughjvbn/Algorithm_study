from itertools import combinations

n,s=map(int,input().split())
nums=list(map(int,input().split()))
result=0
for j in range(1,n+1):
    for i in combinations(nums,j):
        if sum(i)==s:
            result+=1
print(result)