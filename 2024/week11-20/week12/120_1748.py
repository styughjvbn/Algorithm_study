import sys

number=sys.stdin.readline().strip()
num=len(number)

sum=0
for i in range(1,num):
    sum+=(9*10**(i-1))*i

sum+=(int(number)-(10**(num-1)-1))*num

print(sum)