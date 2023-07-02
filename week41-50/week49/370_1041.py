n=int(input())

a,b,c,d,e,f=map(int,input().split())

if n==1:
    print(sum([a,b,c,d,e,f])-max(a,b,c,d,e,f))
else:
    side_1=min(a,b,c,d,e,f)
    side_2=min(a+b,a+d,a+c,a+e,b+d,b+f,b+c,c+e,c+f,e+f,e+d,d+f)
    side_3=min(a+b+c,a+b+d,a+d+e,a+e+c,f+b+c,f+b+d,f+e+d,f+e+c)
    print(4*side_3+(4*(n-1)+4*(n-2))*side_2+(5*((n-2)**2)+4*(n-2))*side_1)
