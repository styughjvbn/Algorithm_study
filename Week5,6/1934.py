import sys
import math

num=int(sys.stdin.readline().strip())
result=[0]*num
for i in range(num):
    a, b = map(int, input().split())
    result[i]=math.lcm(a, b)

for i in result:
    print(i)