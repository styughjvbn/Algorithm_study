import sys

a,p=sys.stdin.readline().split()

arr=[a]
index=0
while True:
    sum=0
    for i in arr[index]:
        sum+=int(i)**int(p)
    if str(sum) in arr:
        print(arr.index(str(sum)))
        break
    arr.append(str(sum))
    index+=1

