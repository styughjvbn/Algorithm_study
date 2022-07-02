import sys

def recur_fibo(num):
    if num==1 or num==2:
        return 1
    else:
        return (recur_fibo(num-1)+recur_fibo(num-2))

def dyna_fibo(num):
    num=num+1
    temp=[0]*num
    temp[1]=temp[2]=1
    count=0
    for i in range(3,num):
        temp[i]=temp[i-1]+temp[i-2]
        count+=1
    return count

usernum=int(sys.stdin.readline().strip())
print(str(recur_fibo(usernum))+" "+str(dyna_fibo(usernum)))


