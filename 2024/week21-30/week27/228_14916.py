n=int(input())

if n==3 or n==1:
    print(-1)
else:
    if (n%5)%2==0:
        print(round(n//5+(n%5)/2))
    else:
        print(round((n//5)-1+((n%5)+5)/2))