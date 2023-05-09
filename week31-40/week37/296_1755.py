n,m=map(int,input().split())
nums=[i for i in range(n,m+1)]
numbers=["zero","one","two","three","four","five","six","seven","eight","nine"]
temp=[]
for i in nums:
    word=""
    for j in str(i):
        word+=numbers[int(j)]
    temp.append([i,word])
temp.sort(key=lambda a:a[1])
k=0
for i in temp:
    if k==10:
        print()
        k=0
    print(i[0],end=" ")
    k+=1