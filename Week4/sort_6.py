import sys

n = int(sys.stdin.readline().strip())

arr=[0]*n

for i in range(n):
    arr[i]=list(map(int,sys.stdin.readline().strip().split()))

arr.sort()
for i in range(n):
    print(" ".join(str(s) for s in arr[i]))