import sys

def fibo(num):
    if num == 0:
        return 0
    elif num==1:
        return 1
    return fibo(num-1)+fibo(num-2)

n = int(sys.stdin.readline().strip())
print(fibo(n))
