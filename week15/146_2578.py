import sys

bingo=[0]*5

for i in range(5):
    temp=list(map(int,sys.stdin.readline().split()))
    bingo[i]=temp

for i in range(5):
    temp=list(map(int,sys.stdin.readline().split()))
    for a in range(5):
        for q in range(5):
            for p in range(5):
                if bingo[q][p]==temp[a]:
                    bingo[q][p]=1
                    break
        bingo_count=0
        for j in range(5):
            is_bingo=0
            for k in range(5):
                is_bingo+=bingo[j][k]
            if is_bingo==5:
                bingo_count+=1
        for j in range(5):
            is_bingo=0
            for k in range(5):
                is_bingo+=bingo[k][j]
            if is_bingo==5:
                bingo_count+=1
        is_bingo = 0
        for j in range(5):
            is_bingo+=bingo[j][j]
        if is_bingo==5:
            bingo_count+=1
        is_bingo = 0
        for j in range(5):
            is_bingo += bingo[j][4-j]
        if is_bingo == 5:
            bingo_count += 1
        if bingo_count>=3:
            print((i)*5+a+1)
            exit()
