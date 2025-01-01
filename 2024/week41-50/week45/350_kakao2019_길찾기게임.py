import sys

sys.setrecursionlimit(10 ** 5)
answer = [[], []]


def solution(nodeinfo):
    node_per_y = {}
    for i, node in enumerate(nodeinfo, 1):
        if node_per_y.get(node[1]):
            node_per_y[node[1]].append([i, node[0]])
        else:
            node_per_y[node[1]] = [[i, node[0]]]
    for i in node_per_y.values():
        i.sort(key=lambda a: a[1])
    nodes = sorted(list(node_per_y.items()), key=lambda a: -a[0])

    dfs(0, 100000, nodes[0][1][0], 1, nodes)
    pre_dfs(0, 100000, nodes[0][1][0], 1, nodes)
    return answer


def dfs(start, end, pres_node, depth, nodes):
    if depth < len(nodes):
        for i in nodes[depth][1]:
            if i[1] < start:
                continue
            if i[1] > end:
                break
            if i[1] < pres_node[1]:
                dfs(start, pres_node[1], i, depth + 1, nodes)
            else:
                dfs(pres_node[1], end, i, depth + 1, nodes)
    answer[1].append(pres_node[0])


def pre_dfs(start, end, pres_node, depth, nodes):
    answer[0].append(pres_node[0])
    if depth >= len(nodes):
        return
    for i in nodes[depth][1]:
        if i[1] < start:
            continue
        if i[1] > end:
            break
        if i[1] < pres_node[1]:
            pre_dfs(start, pres_node[1], i, depth + 1, nodes)
        else:
            pre_dfs(pres_node[1], end, i, depth + 1, nodes)
