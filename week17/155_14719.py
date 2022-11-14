import sys

h,w=map(int,sys.stdin.readline().split())

heghit=list(map(int,sys.stdin.readline().split()))

base=heghit[0]
result=0
temp=0
for i in range(1,w):
    if heghit[i]<base:
        temp+=base-heghit[i]
    else:
        result+=temp
        base=heghit[i]
        temp=0
if temp!=0:
    end=base
    base = heghit[w-1]
    temp = 0
    for i in range(w-2, -1,-1):
        if heghit[i] < base:
            temp += base - heghit[i]
        else:
            result += temp
            base = heghit[i]
            temp = 0
            if heghit[i]==end:
                break
    print(result)
else:
    print(result)