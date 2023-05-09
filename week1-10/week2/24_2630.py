import sys
#재귀를 사용한 분할정복
n=int(sys.stdin.readline().strip())
arr=[0]*n
for i in range(n):
    arr[i]=list(map(int,sys.stdin.readline().split()))

white=0
blue=0
def func(x,y,iter):
    flag=arr[x][y]
    for i in range(iter):
        for j in range(iter):
            if flag!=arr[x+i][y+j]:
                func(x, y, iter // 2)
                func(x+iter//2,y,iter//2)
                func(x,y+iter//2,iter//2)
                func(x+iter//2,y+iter//2,iter//2)
                return 0
    if flag==1:
        global blue
        blue+=1
    else:
        global white
        white+=1
    return 0
func(0,0,n)
print(white)
print(blue)

