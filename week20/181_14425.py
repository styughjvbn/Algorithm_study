import sys

input=sys.stdin.readline

n,m=map(int,input().split())
dic={}
for i in range(n):
    str1=input().strip()
    dic[str1]=1
result=0
for i in range(m):
    str1=input().strip()
    if str1 in dic:
        result+=1

print(result)