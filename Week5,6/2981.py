import sys

num=int(sys.stdin.readline().strip())
value=[0]*num

for i in range(num):
    value[i] = int(sys.stdin.readline().strip())
value.sort()
result=[]
for i in reversed(range(0,value[0]-1)):
    a=value[0]-i
    base=value[0]%(a)
    for j in range(1,len(value)+1):
        if(j==(len(value))):
            result.append(a)
        elif(value[j]%(a)!=base):
            break
for i in range(len(result)):
    print(result[i], end=" ")