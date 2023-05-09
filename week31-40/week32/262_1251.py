str1=input().strip()
temp=[]
for i in range(len(str1)):
    for j in range(i+1,len(str1)-1):
        str2 = list(str1[:i + 1])
        str3 = list(str1[i + 1:j + 1])
        str4 = list(str1[j + 1:])
        str2.reverse()
        str3.reverse()
        str4.reverse()
        tmp=str2+str3+str4
        temp.append("".join(tmp))
temp.sort()
print(temp[0])