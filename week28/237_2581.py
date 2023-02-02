M=int(input())
N=int(input())

num=[1]*10001
num[0]=0
num[1]=0

for i in range(2,10001):
    temp=2
    mulnum=i*temp
    while mulnum <= 10000:
        num[mulnum]=0
        temp+=1
        mulnum=i*temp
sumnum=0
minnum=10001
for i in range(M,N+1):
    if num[i]:
        sumnum+=i
        minnum=min(minnum,i)

if minnum==10001:
    print(-1)
else:
    print(sumnum)
    print(minnum)