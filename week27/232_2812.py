N,K=map(int,input().split())

number=input().strip()

result=[]
for num in number:
    while result and result[-1]<num and K>0:
        result.pop()
        K-=1
    result.append(num)
if K<=0:
    print("".join(map(str,result)))
else:
    print("".join(map(str, result[:-K])))