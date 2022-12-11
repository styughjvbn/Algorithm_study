import sys
input=sys.stdin.readline

n=int(input())
m=int(input())
str1=input().strip()
length=-1
i=0
temp=[]
while i<m:
    # print(" "*i+"*")
    # print(str1, length,end=" ")
    if length==-1:
        if i+2>m-1:
            i+=1
        else:
            if str1[i]=="I" and str1[i+1]=="O" and str1[i+2]=="I":
                length=1
                i+=3
            else:
                i+=1
    else:
        if i+1>m-1:
            temp.append(length)
            length = -1
        else:
            if str1[i]=="O" and str1[i+1]=="I":
                length+=1
                i+=2
            else:
                temp.append(length)
                length=-1
    # print(i)
result=0
for i in (temp):
    if i>=n:
        result+=i-(n-1)
print(result)