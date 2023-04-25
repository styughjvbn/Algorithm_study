import sys
input=sys.stdin.readline
n,m=map(int,input().split())
dic1={}
dic2=[]
for i in range(n):
    name=input().strip()
    dic1[name]=i+1
    dic2.append(name)
for i in range(m):
    tmp=input()
    try:
        tmp=int(tmp)
        print(dic2[tmp-1])
    except:
        print(dic1[tmp.strip()])