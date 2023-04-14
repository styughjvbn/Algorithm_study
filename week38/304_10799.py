
steel=input().strip()
result=0
depth=0
i=0
while i<len(steel):
    if steel[i]=="(":
        if i+1<len(steel) and steel[i+1]==")":
            result += depth
            i+=2
            continue
        else:
            depth+=1
    else:
        result+=1
        depth-=1
    i+=1
print(result)