import sys

x=int(sys.stdin.readline())
i=1
sum=0
direction=False
while True:
    sum+=i
    if x<=sum:
        if direction:
            print(str(i-(sum-x))+'/'+str((1+(sum-x))))
        else:
            print(str((1 + (sum - x)))+ '/' + str(i - (sum - x)) )
        break
    direction=not direction
    i+=1
