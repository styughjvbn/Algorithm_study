n,m=map(int,input().split())
area=[list(map(int,list(input()))) for _ in range(n)]
result=1
for i in range(1,min(n,m)):
    for j in range(n-i):
        for k in range(m-i):
            if area[j][k]==area[j+i][k] and area[j][k]==area[j+i][k+i] and area[j][k]==area[j][k+i]:
                result=max(result,i+1)
print(result**2)
