import sys

n=int(sys.stdin.readline().strip())
dis=list(map(int,sys.stdin.readline().split()))
oil=list(map(int,sys.stdin.readline().split()))

cur_price=oil[0]
distance=0
result=0

#기름의 최저값을 저장해두고 새로운 최저값의 기름이 나오면 그전까지의 거리를 그전까지의 최저가의 기름으로 채운다.
for i in range(n):
    if oil[i]<cur_price:
        result+=distance*cur_price
        distance=0
        if(i!=n-1):
            distance=dis[i]
        cur_price=oil[i]
    else:
        if (i != n - 1):
            distance+=dis[i]
result+=distance*cur_price

print(result)
