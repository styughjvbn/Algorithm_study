import sys
input=sys.stdin.readline

def find(x):
    if line[x]<0:
        return x
    else:
        y=find(line[x])
        line[x]=y
        return y

def union(a,b):
    r_a=find(a)
    r_b=find(b)
    if r_b==r_a:
        return False
    else:
        if line[r_a]<line[r_b]:
            line[r_a]+=line[r_b]
            line[r_b]=r_a
        else:
            line[r_b] += line[r_a]
            line[r_a] = r_b
        return True

while True:
    m, n = map(int, input().split())
    if m==0 and n==0:
        break

    egde = []
    base = 0
    for i in range(n):
        x, y, z = map(int, input().split())
        base += z
        egde.append([x, y, z])
    egde.sort(key=lambda a: a[2])
    line = [-1] * m
    num = 0
    for i in range(n):
        x, y, z = egde[i]
        if union(x, y):
            num += z
    print(base - num)