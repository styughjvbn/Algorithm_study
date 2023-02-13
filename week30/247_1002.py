import math
import sys
input=sys.stdin.readline

T=int(input())

for _ in range(T):
    x1,y1,r1,x2,y2,r2=map(int,input().split())
    if x1==x2 and y1==y2:
        if r1==r2:
            print(-1)
        else:
            print(0)
    else:
        if math.sqrt(math.pow(x1-x2,2)+math.pow(y1-y2,2))>abs(r1+r2):
            print(0)
        elif math.sqrt(math.pow(x1-x2,2)+math.pow(y1-y2,2))<abs(r1+r2):
            if r1>r2:
                if r2+math.sqrt(math.pow(x1-x2,2)+math.pow(y1-y2,2))>r1:
                    print(2)
                elif r2+math.sqrt(math.pow(x1-x2,2)+math.pow(y1-y2,2))<r1:
                    print(0)
                else:
                    print(1)
            else:
                if r1+math.sqrt(math.pow(x1-x2,2)+math.pow(y1-y2,2))>r2:
                    print(2)
                elif r1+math.sqrt(math.pow(x1-x2,2)+math.pow(y1-y2,2))<r2:
                    print(0)
                else:
                    print(1)
        else:
            print(1)