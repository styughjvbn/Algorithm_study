import sys

n=sys.stdin.readline().strip()
while int(n)!=0:
    length=len(n)
    flag=True
    for i in range(length//2):
        if n[i]!=n[-(i)-1]:
            print("no")
            flag=False
            break
    if flag:
        print("yes")
    n = sys.stdin.readline().strip()


