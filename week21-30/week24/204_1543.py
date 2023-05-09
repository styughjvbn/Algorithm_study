str1=input().rstrip()
str2=input().rstrip()
result=0
num=0
while True:
    num=str1.find(str2)
    if num==-1:
        break
    else:
        result+=1
    str1=str1[num+len(str2):]
print(result)