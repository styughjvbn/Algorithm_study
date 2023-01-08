str1=input().strip()

temp=['U', 'C', 'P', 'C']
index=0
result="I hate UCPC"
for i in str1:
    if i==temp[index]:
        index+=1
    if index>3:
        result="I love UCPC"
        break
print(result)
