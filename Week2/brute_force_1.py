import sys

def calc():
    n, m = sys.stdin.readline().strip().split()
    card = sys.stdin.readline().strip().split()
    n = int(n) - 2
    max=0
    for i in range(n):
        for j in range(n - i):
            for k in range(n - i - j):
                sum = int(card[i]) + int(card[j + 1 + i]) + int(card[k + 2 + i + j])
                if sum == int(m):
                    return m
                elif sum<int(m):
                    if max<sum:
                        max=sum
    return max

print(calc())