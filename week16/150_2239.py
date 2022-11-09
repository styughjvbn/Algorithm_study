import sys

sudoku=[]
for i in range(9):
    sudoku.append(list(map(int,list(sys.stdin.readline().strip()))))

def dfs(i,j):
    # for q in range(9):
    #     for p in range(9):
    #         print(sudoku[q][p], end='')
    #     print()
    # print()
    if sudoku[i][j]!=0:
        if j == 8:
            if i == 8:
                for q in range(9):
                    for p in range(9):
                        print(sudoku[q][p],end='')
                    print()
                exit()
            else:
                dfs(i + 1, 0)
        else:
            dfs(i, j + 1)
    else:
        candidate=[0]*10
        for k in range(9):
            candidate[sudoku[i][k]]=1
            candidate[sudoku[k][j]] = 1
        for k in range(3):
            for p in range(3):
                candidate[sudoku[(i//3)*3+k][(j//3)*3+p]]=1

        for k in range(1,10):
            if candidate[k]==0:
                sudoku[i][j]=k
                if j==8:
                    if i==8:
                        for q in range(9):
                            for p in range(9):
                                print(sudoku[q][p], end='')
                            print()
                        exit()
                    else:
                        dfs(i+1,0)
                else:
                    dfs(i,j+1)
                sudoku[i][j]=0

dfs(0,0)