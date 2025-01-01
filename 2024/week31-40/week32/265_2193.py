n=int(input())
temp=[0]*91
temp[1]=1
temp[2]=1
for i in range(3,91):
    temp[i]=temp[i-1]+temp[i-2]
print(temp[n])