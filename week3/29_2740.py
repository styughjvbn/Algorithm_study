import sys
#기본적인 행렬곱셈 구현
n,m=map(int,sys.stdin.readline().split())
arr1=[0]*n
for i in range(n):
    arr1[i]=list(map(int,sys.stdin.readline().split()))

m,k=map(int,sys.stdin.readline().split())
arr2=[0]*m
for i in range(m):
    arr2[i]=list(map(int,sys.stdin.readline().split()))

result=[[0 for i in range(k)]for _ in range(n)]

for q in range(k):
    for a in range(n):
        for j in range(m):
            result[a][q]+=arr1[a][j]*arr2[j][q]


for i in range(n):
    print(' '.join(map(str,result[i])))