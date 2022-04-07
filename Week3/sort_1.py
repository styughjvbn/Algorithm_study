import sys

def calc():
    n = int(sys.stdin.readline().strip())

    arr=[]

    for i in range(n):
        arr.append(int(sys.stdin.readline().strip()))

    arr.sort()
    for i in range(n):
        print(arr[i])
    return arr

calc()