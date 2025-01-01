n=int(input())
positive=[]
one=[]
negative=[]
zero=False
for i in range(n):
    num=int(input())
    if num==0:
        zero=True
    elif num==1:
        one.append(num)
    elif num>0:
        positive.append(num)
    else:
        negative.append(num)
positive.sort(reverse=True)
negative.sort()
result=0
if len(negative)%2==0:
    for i in range(0,len(negative),2):
        result+=negative[i]*negative[i+1]
else:
    for i in range(1,len(negative),2):
        result+=negative[i-1]*negative[i]
    if not zero:
        result+=negative[-1]
for i in range(1,len(positive),2):
    result+=positive[i-1]*positive[i]
if len(positive)%2==1:
    result+=positive[-1]

print(result+sum(one))