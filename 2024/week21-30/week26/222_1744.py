import sys

input=sys.stdin.readline

N=int(input())

plus_number=[]
minus_number=[]
zero=False
for _ in range(N):
    temp=int(input())
    if temp>0:
        plus_number.append(temp)
    if temp<0:
        minus_number.append(temp)
    if temp==0:
        zero=True
result=0
plus_number.sort(reverse=True)
minus_number.sort()
for i in range(0,len(plus_number),2):
    try:
        if plus_number[i] != 1 and plus_number[i+1]!=1:
            result+=plus_number[i]*plus_number[i+1]
        else:
            result+=plus_number[i]+plus_number[i+1]
    except:
        result += plus_number[-1]

for i in range(0,len(minus_number),2):
    try:
        result+=minus_number[i]*minus_number[i+1]
    except:
        if not zero:
            result+=minus_number[-1]

print(result)