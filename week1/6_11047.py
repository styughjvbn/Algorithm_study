import sys
#그리디 알고리즘
n,k=map(int,sys.stdin.readline().split())

arr=[0]*n

for i in range(n):
    arr[i]=int(sys.stdin.readline())

coin_count=0
iter=n-1
# i번째 동전이 i-1번째 동전의 배수이기 때문에 그리디 알고리즘이 가능하다.
while True:
    if iter<0:
        break
    coin_count+=k//arr[iter]
    k%=arr[iter]
    iter-=1

print(coin_count)