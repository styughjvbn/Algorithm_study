from itertools import permutations
t=int(input())
oper=["","+","-"]

oper1=[" ","+","-"]

def dfs(idx,depth,n,temp,temp_print):
    if depth==n-1:
        if eval(temp) == 0:
            print(temp_print)
    else:
        dfs(0,depth+1,n,temp+oper[0]+str(depth+2),temp_print+oper1[0]+str(depth+2))
        dfs(1, depth + 1, n, temp + oper[1] + str(depth+2),temp_print+oper1[1]+str(depth+2))
        dfs(2, depth + 1, n, temp + oper[2] + str(depth+2),temp_print+oper1[2]+str(depth+2))

for i in range(t):
    n=int(input())
    dfs(0,0,n,"1","1")
    print()