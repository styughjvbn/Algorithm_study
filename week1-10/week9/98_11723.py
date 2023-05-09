import sys

m=int(sys.stdin.readline())
result_set=[0]*20

for i in range(m):
    operation=sys.stdin.readline().split()
    if operation[0]=="add":
        result_set[int(operation[1])-1]=1
    elif operation[0]=="remove":
        result_set[int(operation[1]) - 1] = 0
    elif operation[0]=="check":
        if result_set[int(operation[1]) - 1] == 1:
            print(1)
        else:
            print(0)
    elif operation[0]=="toggle":
        result_set[int(operation[1]) - 1] = (result_set[int(operation[1]) - 1]+1)%2
    elif operation[0]=="all":
        for i in range(20):
            result_set[i] = 1
    elif operation[0]=="empty":
        for i in range(20):
            result_set[i] = 0


