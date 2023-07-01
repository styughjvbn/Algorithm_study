n=int(input())


if n<=10:
    print(n)
else:
    n-=10
    num = 11
    while num<=9876543210:
        str_num=str(num)
        idx=-1
        for i in range(len(str_num)-1):
            if ord(str_num[i])<=ord(str_num[i+1]):
                idx=i
                break
        if idx==-1:
            n -= 1
            if n == 0:
                break
            num+=1
        else:
            tmp_num=int(str_num[:idx+1])+1
            num=tmp_num*(10**(len(str_num)-1-idx))

    else:
        print(-1)
        exit()
    print(num)