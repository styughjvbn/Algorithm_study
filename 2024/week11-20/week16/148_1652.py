import sys

n=int(sys.stdin.readline())
arr=[]
for i in range(n):
    arr.append(list(sys.stdin.readline()))
colum=0
row=0
for i in range(n):
    base=0
    for j in range(n):
        if arr[i][j]=='.':
            base+=1
        else:
            if base>=2:
                row+=1
            base=0
    if base>=2:
        row+=1
for i in range(n):
    base=0
    for j in range(n):
        if arr[j][i]=='.':
            base+=1
        else:
            if base>=2:
                colum+=1
            base=0
    if base>=2:
        colum+=1
        
print(row,colum)
