import sys

sudoku=[list((map(int,sys.stdin.readline().split()))) for _ in range(9)]
zero=[]
for i in range(9):
    for j in range(9):
        if sudoku[i][j]==0:
            zero.append([i,j])

def remain_num(i,j):
    num=[1,2,3,4,5,6,7,8,9]
    for k in range(9):
        if sudoku[i][k]!=0:
            num[sudoku[i][k]-1]=0
    for k in range(9):
        if sudoku[k][j]!=0:
            num[sudoku[k][j]-1]=0
    i=i//3
    j=j//3

    for k in range(3):
        for p in range(3):
            if sudoku[i*3+k][j*3+p]!=0:
                num[sudoku[i*3+k][j*3+p]-1]=0


    return_num=[]
    for q in range(9):
        if num[q]!=0:
            return_num.append(num[q])
    return return_num

flag=False

def dfs(x):
    global flag
    if flag:
        return
    if len(zero)==x:
        for q in sudoku:
            print(*q)
        flag=True
        return
    else:
        [i,j]=zero[x]
        number=remain_num(i,j)
        for k in number:
            sudoku[i][j]=k
            dfs(x+1)

            sudoku[i][j]=0

dfs(0)