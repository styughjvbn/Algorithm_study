import sys
input=sys.stdin.readline

str1=input().strip()

tail=[]
for i in range(len(str1)):
    tail.append(str1[i:])
tail.sort()
for i in range(len(str1)):
    print(tail[i])