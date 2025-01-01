n=int(input())
result=0
for i in range(n):
    word=input().strip()
    temp=[]
    prev_char=""
    for i in word:
        if i in temp:
            if prev_char==i:
                continue
            else:
                break
        else:
            temp.append(i)
            prev_char=i
    else:
        result+=1
print(result)