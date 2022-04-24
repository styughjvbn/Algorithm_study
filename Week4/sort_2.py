import sys

n = int(sys.stdin.readline().strip())

arr=[0]*n

for i in range(n):
    arr[i]=(int(sys.stdin.readline().strip()))

arr.sort()
for i in range(n):
    print(arr[i])