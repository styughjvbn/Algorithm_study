import sys

n,k=map(int,sys.stdin.readline().split())

country=[0]*n
jey=[]
for _ in range(n):
    temp=list(map(int, sys.stdin.readline().split()))
    country[temp[0]-1]=temp[1:]
    if temp[0]-1==k-1:
        jey=temp[1:]
count=0
country.sort(reverse=True)
for i in range(1000):
    if country[i][0]>jey[0]:
        count+=1
    else:
        if country[i][1] > jey[1]:
            count += 1
        else:
            if country[i][2] > jey[2]:
                count += 1
            else:
                break

print(count+1)