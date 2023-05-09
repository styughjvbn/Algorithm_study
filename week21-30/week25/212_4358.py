import sys
input=sys.stdin.readline

dic={}
num=0
while True:
    tree=input().strip()
    if tree=="":
        break
    num+=1
    if tree in dic:
        dic[tree]+=1
    else:
        dic[tree]=1

dic=sorted(dic.items(),key=lambda a:a[0])
for i in dic:
    print(i[0],"{:.4f}".format(i[1]/num*100))
