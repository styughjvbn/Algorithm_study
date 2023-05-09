import sys

temp=sys.stdin.readline().strip()
tmp=temp.split('<')
a=tmp[0].split()
for i in range(len(a)):
    for k in range(len(a[i]) - 1, -1, -1):
        print(a[i][k], end="")
    if i!=len(a)-1:
        print(" ",end="")
for i in range(1,len(tmp)):
    print("<",end="")
    for j in range(len(tmp[i])):
        print(tmp[i][j],end="")
        if tmp[i][j]=='>':
            a = tmp[i][j+1:].split()
            for k in range(len(a)):
                for p in range(len(a[k]) - 1, -1, -1):
                    print(a[k][p], end="")
                if k!=len(a)-1:
                    print(" ",end="")
            break