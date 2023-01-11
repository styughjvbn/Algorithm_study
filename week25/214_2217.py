import sys

input=sys.stdin.readline

n=int(input())
number=[]
for i in range(n):
    number.append(int(input()))

number.sort(reverse=True)

result=number[0]*(1)

for i in range(1,n):
    temp=number[i]*(i+1)
    if result<temp:
        result=temp
print(result)