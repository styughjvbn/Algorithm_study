n=int(input())
def check(num):
    flag=False
    for i in range(1,(len(num)//2)+1):
        for j in range(len(num)-i):
            if num[j:j+i] == num[j+i:j+i+i]:
                flag=True
    return flag
if n==1:
    print(1)
else:
    numbers=[1,2,3]
    for i in range(n-1):
        temp=[]
        for j in numbers:
            for k in range(3):
                if str(j)[-1]==str(k+1):
                    continue
                tmp=str(j)+str(k+1)
                if not check(tmp):
                    temp.append(tmp)
        temp.sort()
        numbers=temp[:10]

    print(numbers[0])