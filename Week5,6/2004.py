import sys
import math

[num1,num2]=list(map(int,(sys.stdin.readline().strip().split())))

num=str(math.comb(num1,num2))
zero=0
for i in reversed(num):
    if i=="0":
        zero+=1
    else:
        break

print(num)
print(zero)