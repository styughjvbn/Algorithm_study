import sys

input = sys.stdin.readline
sys.setrecursionlimit(10 ** 6)

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
dp = [[-1] * n for _ in range(n)]
move = [(0, 1), (1, 0), (0, -1), (-1, 0)]
ans = 0


def dfs(x, y):
    if dp[x][y] == -1:
        dp[x][y] = 0

        for a, b in move:
            dx = x + a;
            dy = y + b
            if n > dx >= 0 and n > dy >= 0 and board[dx][dy] > board[x][y]:
                dp[x][y] = max(dp[x][y], dfs(dx, dy))

    return dp[x][y] + 1


for i in range(n):
    for j in range(n):
        ans = max(ans, dfs(i, j))

print(ans)