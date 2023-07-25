n=int(input())
num=0
while True:
    num+=1
    if "666" in str(num):
        n-=1
    if n==0:
        print(num)
        break