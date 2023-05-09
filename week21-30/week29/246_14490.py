import math

a,b=map(int,input().split(":"))

gcd=math.gcd(a,b)
print(str(a//gcd)+":"+str(b//gcd))