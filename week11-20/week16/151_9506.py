import sys

n=1
while n:
    n=int(sys.stdin.readline())
    if n==-1:
        break
    number=[]
    sum=0
    for i in range(1,n):
        if n%i==0:
            number.append(i)
            sum+=i

    if sum==n:
        print(n,'=',' + '.join(map(str,number)))
    else:
        print(n,"is NOT perfect.")
