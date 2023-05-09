from itertools import permutations
n=int(input())
sign=list(input().strip().split())
num=[i for i in range(10)]
case=list(permutations(num,n+1))
min_num=10**10
max_num=0
next=False
for i in range(len(case)):
    flag=True
    for j in range(1,n+1):
        if sign[j-1]=="<":
            if case[i][j-1]>case[i][j]:
                flag=False
                break
        else:
            if case[i][j-1]<case[i][j]:
                flag=False
                break
    if flag:
        number=0
        mul=1
        for k in range(len(case[i])-1,-1,-1):
            number+=mul*case[i][k]
            mul*=10
        min_num=min(min_num,number)
        max_num = max(max_num, number)

print(format(max_num,"0"+str(n+1)))
print(format(min_num,"0"+str(n+1)))