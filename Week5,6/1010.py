import sys
import math

num=int(sys.stdin.readline().strip())
result=[0]*num
for i in range(num):
    [num1, num2] = list(map(int, sys.stdin.readline().strip().split()))
    result[i]=math.comb(num2,num1)

for i in result:
    print(i)