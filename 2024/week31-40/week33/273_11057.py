n=int(input())

#누적합을 구할 리스트
num=[1]*10

#n-1번 반복해서 누적합을 구한다.
for _ in range(n-1):
    for i in range(1,10):
        num[i]=num[i]+num[i-1]
print(sum(num)%10007)