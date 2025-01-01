import sys

n=int(sys.stdin.readline())

swit=list(map(int,sys.stdin.readline().split()))

stu_n=int(sys.stdin.readline())

for i in range(stu_n):
    sex,swi_count=map(int,sys.stdin.readline().split())
    if sex==1:
        for j in range(swi_count-1,n,swi_count):
            swit[j]=(swit[j]+1)%2
        # print("남자끝")
        # for i in range(1, n + 1):
        #     print(swit[i - 1], end=" ")
        #     if i % 20 == 0:
        #         print()
    else:
        base=1
        swit[swi_count-1] = (swit[swi_count-1] + 1) % 2
        while True:
            if swi_count-1-base > -1 and swi_count-1+base<n:
                if swit[swi_count-1-base]==swit[swi_count-1+base]:
                    swit[swi_count - 1 - base]=(swit[swi_count - 1 - base] + 1) % 2
                    swit[swi_count - 1 + base] = (swit[swi_count - 1 + base] + 1) % 2
                else:
                    break
                base+=1
            else:
                break
for i in range(len(swit)):
    if i%20==0 and i!=0:
        print()
    print(swit[i],end=" ")

