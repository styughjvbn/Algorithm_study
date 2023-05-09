import math
import sys

n=sys.stdin.readline().strip()
number=[0]*10
for i in n:
    number[int(i)]+=1

temp=math.ceil((number[6]+number[9])/2)
number[6]=temp
number[9]=temp
max_num=max(number)
print(max_num)