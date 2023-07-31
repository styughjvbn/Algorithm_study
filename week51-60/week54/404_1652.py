n=int(input())
room=[list(input().strip()) for _ in range(n)]
room2=list(zip(*room))
result1=0
for i in room:
    count=0
    flag=False
    for j in range(len(i)-1):
        if i[j] ==".":
            if i[j+1]==".":
                flag=True
            else:
                if flag:
                    count+=1
                    flag=False
    if flag:
        count += 1
        flag = False
    result1+=count
result2=0
for i in room2:
    count=0
    flag=False
    for j in range(len(i)-1):
        if i[j] ==".":
            if i[j+1]==".":
                flag=True
            else:
                if flag:
                    count+=1
                    flag=False
    if flag:
        count += 1
        flag = False
    result2+=count
print(result1,result2)