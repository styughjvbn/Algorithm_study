import sys

def calc():
    n = int(sys.stdin.readline().strip())

    bulk=[]
    for i in range(n):
        bulk.append(sys.stdin.readline().strip().split())
    rank=""
    for i in range(n):
        taller = 1
        for j in range(n):
            if int(bulk[i][1])<int(bulk[j][1]) and int(bulk[i][0])<int(bulk[j][0]):
                taller+=1
        rank+=str(taller)+" "
    return rank

print(calc())