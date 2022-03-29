import sys

def calc():
    n = int(sys.stdin.readline().strip())

    iterate=666
    count=0
    while(1):
        if str(iterate).find("666")!=-1:
            count+=1
        if(count==n):
            break
        iterate += 1
    return iterate

print(calc())