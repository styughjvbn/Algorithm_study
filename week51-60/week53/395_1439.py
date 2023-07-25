
string=input().strip()
num=0
for i in string.split("0"):
    if i:
        num+=1
num2=0
for i in string.split("1"):
    if i:
        num2+=1
print(min(num2,num))