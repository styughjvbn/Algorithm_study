str1=input().strip()

X=str1.split(".")
result=""
for i in X:
    if len(i)%2==1:
        print(-1)
        exit()
    else:
        result+=(len(i)//4)*"AAAA"
        result+=(len(i)%4)//2*"BB"
        result+="."
result=result[:-1]
print(result)
