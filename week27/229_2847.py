import sys
input=sys.stdin.readline
N=int(input())

numbers=[]
for _ in range(N):
    numbers.append(int(input()))

result=0
base=numbers[-1]
for i in range(N-2,-1,-1):
    if numbers[i]<base:
        base=numbers[i]
    else:
        result+=numbers[i]-base+1
        base-=1

print(result)