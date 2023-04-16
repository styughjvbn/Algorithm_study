import sys
from itertools import permutations

input=sys.stdin.readline

n=int(input())
matrix=[list(map(int,input().split())) for _ in range(n)]
nums=[i for i in range(1,n)]
case=list(permutations(nums,n-1))

min_cost=10**7
for i in case:
    cost=0
    temp=False
    if matrix[0][i[0]]==0:
        continue
    cost=matrix[0][i[0]]
    if cost > min_cost:
        continue
    for j in range(1, len(i)):
        if temp:
            break
        if matrix[i[j - 1]][i[j]] == 0:
            temp=True
            continue
        else:
            cost += matrix[i[j - 1]][i[j]]
            if cost > min_cost:
                temp = True
                continue
    if temp:
        continue
    if matrix[i[-1]][0]==0:
        continue
    else:
        cost+=matrix[i[-1]][0]
        min_cost=min(cost,min_cost)
print(min_cost)
