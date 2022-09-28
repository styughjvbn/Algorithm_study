import sys

n=int(sys.stdin.readline())
strings=[]
for i in range(n):
    strings.append(list(sys.stdin.readline().strip()))

result=strings[0]
if n==1:
    print("".join(result))
else:
    for i in range(1,n):
        for j in range(len(result)):
            if result[j]!=strings[i][j]:
                result[j]='?'
    print("".join(result))