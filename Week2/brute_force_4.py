import sys

def calc():
    n,m = sys.stdin.readline().strip().split()
    n,m=int(n),int(m)
    board=[]
    for i in range(n):
        board.append(sys.stdin.readline().strip())

    start = "W"
    counts=[]
    for k in range(n-7):
        for p in range(m-7):
            count = 0
            for i in range(8):
                for j in range(8):
                    if board[k+i][p+j] != start:
                        count += 1
                    if start == "W":
                        start = "B"
                    else:
                        start = "W"
                if start == "W":
                    start = "B"
                else:
                    start = "W"
            counts.append(count)
    counts.sort()
    if counts[0]<64-counts[len(counts)-1]:
        return counts[0]
    else:
        return 64-counts[len(counts)-1]

print(calc())