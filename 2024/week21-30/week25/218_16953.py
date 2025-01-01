n1,n2=map(int,input().split())

result=0
while True:

    if n2%10==1:
        n2=n2//10
    else:
        n2=n2/2
    result += 1
    if n2==n1:
        print(result+1)
        break
    if n1>n2:
        print(-1)
        break


