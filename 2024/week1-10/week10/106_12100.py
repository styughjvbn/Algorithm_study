import sys

n=int(sys.stdin.readline())

board=[]
for i in range(n):
    board.append(list(map(int,sys.stdin.readline().split())))

def move(line):
    length=len(line)
    temp_line=[]
    result_line=[0]*length
    for k in range(length):
        if line[k]!=0:
            temp_line.append(line[k])
    i=0
    j=0

    while i<len(temp_line)-1:
        if temp_line[i]==temp_line[i+1]:
            result_line[j]=temp_line[i]*2
            i+=2
        else:
            result_line[j]=temp_line[i]
            i+=1
        j+=1
    if i==len(temp_line)-1:
        result_line[j] = temp_line[i]

    return result_line

result=0
def dfs(dfs_board,iter,dir):
    global result
    if iter==5:
        result=max(result,max(map(max,*dfs_board)))
        return
    else:
        temp=[[0 for _ in range(n)]for _ in range(n)]
        if dir==0:
            for i in range(n):
                temp[i]=(move(dfs_board[i]))
        elif dir==1:
            for i in range(n):
                var=[0]*n
                for j in range(n-1,-1,-1):
                    var[n-j-1]=dfs_board[j][i]
                var=move(var)
                for j in range(n-1,-1,-1):
                    temp[j][i]=var[n-j-1]
        elif dir==2:
            for i in range(n):
                var=[0]*n
                for j in range(n-1,-1,-1):
                    var[n-j-1]=dfs_board[i][j]
                var=move(var)
                for j in range(n-1,-1,-1):
                    temp[i][j]=var[n-j-1]
        elif dir==3:
            for i in range(n):
                var=[0]*n
                for j in range(n):
                    var[j]=dfs_board[j][i]
                var=move(var)
                for j in range(n):
                    temp[j][i]=var[j]
        dfs(temp,iter+1,0)
        dfs(temp, iter + 1, 1)
        dfs(temp, iter + 1, 2)
        dfs(temp, iter + 1, 3)
if n==1:
    print(board[0][0])
else:
    dfs(board,0,0)
    dfs(board,0,1)
    dfs(board,0,2)
    dfs(board,0,3)
    print(result)

