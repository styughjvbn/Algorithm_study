import sys

input=sys.stdin.readline
n=int(input())
expec_rank=[]
for i in range(n):
    expec_rank.append(int(input()))

expec_rank.sort()
result=0
for i in range(n):
    result+=abs(expec_rank[i]-(i+1))
print(result)