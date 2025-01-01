str1=input()

if not "0" in str1:
    print(-1)
    exit()
sum=0
for i in str1:
    sum+=int(i)

if sum%3==0:
    temp=list(str1)
    temp.sort(reverse=True)
    print("".join(temp))
else:
    print(-1)