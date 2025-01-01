n=int(input())

b={}
for j in range(n):
    book=input().strip()
    if b.get(book)!=None:
        b[book]+=1
    else:
        b[book] =1
result=sorted(b.items(),key=lambda a:(-a[1],a[0]),)
print(result[0][0])