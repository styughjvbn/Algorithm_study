import sys

input=sys.stdin.readline
n=int(input())
files=[input().strip() for _ in range(n)]
result={}
for i in files:
    spl=i.split(".")
    try:
        result[spl[1]]+=1
    except:
        result[spl[1]]=1

result=sorted(result.items(),key=lambda a:a[0])
for i in result:
    print(i[0],i[1])
