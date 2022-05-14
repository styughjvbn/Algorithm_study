import sys
import math

num=int(sys.stdin.readline().strip())
value=[0]*num

value = list(map(int,(sys.stdin.readline().strip().split())))

first_num=value[0]
result=[0]*(num-1)
for i in range(1,len(value)):
    GCD=int(math.gcd(first_num,value[i]))
    result[i-1]=str(first_num//GCD)+"/"+str(value[i]//GCD)

for i in range(len(result)):
    print(result[i], end=" ")