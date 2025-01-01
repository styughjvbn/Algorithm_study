import sys
N = int(input())
world = []
for _ in range(N):
    world.append(list(map(int, sys.stdin.readline().split())))

dp = {}
def DFS(now, visited):
    if visited == (1 << N) - 1:
        if world[now][0]:
            return world[now][0]
        else:
            return int(1e9)

    if (now, visited) in dp:
        return dp[(now, visited)]

    min_cost = int(1e9)
    for next in range(1, N):
        if world[now][next] == 0 or visited & (1 << next):
            continue
        cost = DFS(next, visited | (1 << next)) + world[now][next]
        min_cost = min(cost, min_cost)

    dp[(now, visited)] = min_cost
    return min_cost


print(DFS(0, 1))