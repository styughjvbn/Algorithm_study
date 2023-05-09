import sys
#재귀를 사용한 분할정복
n=int(sys.stdin.readline().strip())
arr=[0]*n
for i in range(n):
    arr[i]=sys.stdin.readline().strip()

result=[]
def func(x,y,iter):
    global result
    flag=arr[x][y]
    for i in range(iter):
        for j in range(iter):
            if flag!=arr[x+i][y+j]:
                result.append('(')
                result.append(func(x, y, iter // 2))
                result.append(func(x, y + iter // 2, iter // 2))
                result.append(func(x+iter//2,y,iter//2))
                result.append(func(x+iter//2,y+iter//2,iter//2))
                result.append(')')
                return ''
    if flag=='1':
        return '1'
    else:
        return '0'
result.append(func(0,0,n))

print(''.join(result))
