n, m = list(map(int, input().split()))

s = []


def dfs(num):
    if len(s) == m:
        print(' '.join(map(str, s)))
        return

    for i in range(num, n + 1):
        if i not in s:
            s.append(i)
            dfs(i)
            s.pop()


dfs(1)