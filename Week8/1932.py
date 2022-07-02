import sys

num=int(sys.stdin.readline().strip())
arr=[0]*num
for i in range(num):
    arr[i]=list(map(int, sys.stdin.readline().strip().split()))

for i in range(1,num):
    for j in range(len(arr[i])):
        if(j==0):
            arr[i][j]+=arr[i-1][j]
        elif(j==len(arr[i])-1):
            arr[i][j]+=arr[i-1][j-1]
        else:
            if(arr[i-1][j-1]>arr[i-1][j]):
                arr[i][j]+=arr[i-1][j-1]
            else:
                arr[i][j] += arr[i-1][j]

print(max(arr[num-1]))