n=int(input())
num=0
arr=[]
while num<=9876543210:
    temp_num=str(num)
    digit=len(temp_num)
    flag=True
    for i in range(1,len(temp_num)):
        if temp_num[i]>=temp_num[i-1]:
            flag=False
            break
        else:
            digit-=1
    if flag:
        arr.append(num)
    # print(num,digit)
    num+=10**(digit-1)
    num-=num%(10**(digit-1))
if n>=len(arr):
    print(-1)
else:
    print(arr[n])