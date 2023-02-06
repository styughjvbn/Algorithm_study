n=input().strip()
result=0
while len(n)>1:
    temp=0
    for i in n:
        temp+=int(i)
    n=str(temp)
    result+=1
print(result)
if int(n)%3==0:
    print("YES")
else:
    print("NO")