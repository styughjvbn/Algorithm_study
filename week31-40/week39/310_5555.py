search=input().strip()
n=int(input())
strs=[input().strip() for _ in range(n)]

result=0

for i in range(n):
    con = False

    for j in range(10):
        if con:
            break
        if search[0]==strs[i][j]:
            flag=True
            for k in range(len(search)):
                if search[k]!=strs[i][(j+k)%10]:
                    flag=False
            if flag:
                result+=1
                con=True
print(result)