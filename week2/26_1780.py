import sys
#재귀를 사용한 분할정복
n=int(sys.stdin.readline().strip())
arr=[0]*n
for i in range(n):
    arr[i]=list(map(int,sys.stdin.readline().split()))

zero=0
one=0
minus=0
def func(x,y,iter):
    global zero
    global one
    global minus
    flag=arr[x][y]
    for i in range(iter):
        for j in range(iter):
            if flag!=arr[x+i][y+j]:
                func(x, y, iter // 3)
                func(x, y + iter // 3, iter // 3)
                func(x, y + (iter // 3)*2, iter // 3)
                func(x+iter//3,y,iter//3)
                func(x + iter // 3, y+ iter // 3, iter // 3)
                func(x + iter // 3, y+ (iter // 3)*2, iter // 3)
                func(x+(iter//3)*2,y,iter//3)
                func(x + (iter // 3) * 2, y + iter // 3, iter // 3)
                func(x + (iter // 3) * 2, y + (iter // 3)*2, iter // 3)
                return 0
    if flag==1:
        one+=1
        return 1
    elif flag==0:
        zero+=1
        return 0
    else:
        minus+=1
        return -1
func(0,0,n)

print(minus)
print(zero)
print(one)
