import sys
import math

num=int(sys.stdin.readline().strip())

num=str(math.factorial(num))
zero=0
for i in reversed(num):
    if i=="0":
        zero+=1
    else:
        break
print(zero)