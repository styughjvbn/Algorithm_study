import sys

sys.setrecursionlimit(10 ** 6)


def fac(num):
    if num < 1:
        return 1
    return fac(num-1)*num


n = int(sys.stdin.readline().strip())
print(fac(n))
