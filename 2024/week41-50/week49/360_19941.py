n,k=map(int,input().split())
line=list(input().strip())
result=0
for i in range(len(line)):
    flag=False
    if line[i]=="P":
        for j in range(k,0,-1):
            if flag:
                break
            if i-j>=0:
                if line[i-j]=="H":
                    line[i-j]="X"
                    flag=True
                    result+=1
        for j in range(1,k+1):
            if flag:
                break
            if i+j<len(line):
                if line[i+j]=="H":
                    line[i+j]="X"
                    flag = True
                    result += 1
print(result)