a,b=input().strip().split()

result=50
for i in range(len(b)-len(a)+1):
    diff=0
    for j in range(len(a)):
        if a[j]!=b[j+i]:
            diff+=1
    result=min(diff,result)

print(result)