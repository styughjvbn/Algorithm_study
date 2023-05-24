
while True:
    try:
        n=int(input())
        num="1"
        while True:
            if int(num)%n==0:
                print(len(num))
                break
            else:
                num+="1"
    except:
        exit()
