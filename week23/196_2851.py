import sys
input=sys.stdin.readline
arr=[]
for i in range(10):
    arr.append(int(input().strip()))

for i in range(1,10):
    arr[i]+=arr[i-1]

result=0
temp=0
for i in range(10):
    if arr[i]>100:
        temp=i
        break
if temp==0:
    print(arr[9])
else:
    if arr[i]-100==100-arr[i-1]:
        print(arr[i])
    elif arr[i]-100>100-arr[i-1]:
        print(arr[i-1])
    else:
        print(arr[i])