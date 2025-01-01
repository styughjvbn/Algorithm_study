import sys

input=sys.stdin.readline

n,m=map(int,input().split())
name={}
aa=[]
for i in range(n+m):
    temp=input().strip()
    try:
        name[temp]+=1
        aa.append(temp)
    except:
        name[temp]=1
aa.sort()
print(len(aa))
for i in range(len(aa)):
    print(aa[i])