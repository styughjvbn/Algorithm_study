import sys

n,k=map(int,sys.stdin.readline().split())
number=[0]*(n-1)
number=[1,1]+number
stack=number.index(0)
result=0
while True:
    temp=number.index(0)
    while temp<=n:
        if number[temp]==0:
            number[temp]=1

            result+=1
            if result==k:
                print(temp)
                exit()
        temp += stack

    try:
        stack = number.index(0)
    except:

        break

