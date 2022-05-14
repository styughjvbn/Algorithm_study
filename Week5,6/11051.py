import sys
import math

[num1,num2]=list(map(int,sys.stdin.readline().strip().split()))

print(math.comb(num1,num2)%10007)