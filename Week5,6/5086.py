import sys

[n, m] = (sys.stdin.readline().strip().split())
while n!=m:
    n=int(n)
    m=int(m)
    if n>m:
        if n%m==0:
            print("multiple")
        else:
            print("neither")
    else:
        if m%n==0:
            print("factor")
        else:
            print("neither")
    [n, m] = (sys.stdin.readline().strip().split())
