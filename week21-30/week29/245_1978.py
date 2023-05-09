import sys
input=sys.stdin.readline
n=int(input())
temp=list(map(int,input().split()))
number=[0]*(1000)
number=[1,1]+number
stack=number.index(0)
for i in range(2,1001):
    num=2
    while num*i<=1000:
        number[num*i]=1
        num+=1
result=0
for i in range(n):
    if number[temp[i]]==0:
        result+=1
print(result)