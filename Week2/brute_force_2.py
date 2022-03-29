import sys

def calc():
    n = sys.stdin.readline().strip()
    num=(len(n)-1)*9+(int(n[0])-1)
    n = int(n)
    for i in reversed(range(1,num+1)):
        temp=n-i
        str_temp=str(temp)
        for j in range(len(str_temp)):
            temp+=int(str_temp[j])
        if(temp==n):
            return n-i

    return 0

print(calc())