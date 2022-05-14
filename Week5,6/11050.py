import sys
import math

[num1,num2]=list(map(int,sys.stdin.readline().strip().split()))

print(int(math.factorial(num1)/math.factorial(num2)/math.factorial(num1-num2)))