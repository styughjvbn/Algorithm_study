def solution(m, n, board):
    answer = 0
    earase = []
    new_board = []
    for i in zip(*board):
        new_board.append(list(i))
    while True:
        earase = [[0 for i in range(m)] for _ in range(n)]
        flag = False
        for i in range(n):
            for j in range(m):
                base = new_board[i][j]
                if i < n - 1 and j < m - 1:
                    if base == "#":
                        earase[i][j] = 1
                        continue
                    if base == new_board[i + 1][j] and base == new_board[i + 1][j + 1] and base == new_board[i][j + 1]:
                        flag = True
                        earase[i][j] = 1
                        earase[i + 1][j] = 1
                        earase[i][j + 1] = 1
                        earase[i + 1][j + 1] = 1
                else:
                    if base == "#":
                        earase[i][j] = 1
        if not flag:
            break
        for i in range(n):
            line = "#" * earase[i].count(1)
            for j in range(m):
                if earase[i][j] == 0 and new_board[i][j] != "#":
                    line += new_board[i][j]
            new_board[i] = line

    for i in range(n):
        for j in range(m):
            if new_board[i][j] == "#":
                answer += 1
    return answer