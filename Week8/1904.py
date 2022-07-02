import sys

def dyna_fibo(num):
    num=num+1
    temp=[0]*num
    temp[1]=1
    if(num>2):
        temp[2]=2
    for i in range(3,num):
        temp[i]=temp[i-1]%15746+temp[i-2]%15746
    return temp[num-1]%15746

usernum=int(sys.stdin.readline().strip())
print(str(dyna_fibo(usernum)))