from itertools import combinations

n=int(input())
case=[]
temp=[]
for i in range(n):
    a,b=map(int,input().split())
    temp.append([a,b])
for i in range(1,n+1):
    case.append(list(combinations(range(n),i)))
result=10**100
for i in case:
    for j in i:
        mat1=1
        mat2=0
        for k in j:
            mat1*=temp[k][0]
            mat2+=temp[k][1]
        result=min(result,abs(mat1-mat2))
print(result)