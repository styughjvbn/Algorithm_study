n=int(input())

if n<100:
    print(n)
else:
    count = 0
    for i in range(100,n+1):
        str_i=str(i)
        is_hansoo=True
        base=int(str_i[0])-int(str_i[1])
        for j in range(1,len(str_i)-1):
            if (int(str_i[j])-int(str_i[j+1]))!=base:
                is_hansoo=False
                break
        if is_hansoo:
            count+=1
    print(count+99)