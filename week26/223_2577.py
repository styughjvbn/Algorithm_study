n1=int(input())
n2=int(input())
n3=int(input())

n4=n1*n2*n3
temp=[0]*10
for i in str(n4):
    temp[int(i)]+=1

for i in temp:
    print(i)