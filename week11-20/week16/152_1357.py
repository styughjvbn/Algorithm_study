import sys

n=list(map(list,sys.stdin.readline().split()))
n[0].reverse()
n[1].reverse()

temp=int(''.join(n[0]))+int(''.join(n[1]))
temp=list(str(temp))
temp.reverse()
print(int(''.join(temp)))
