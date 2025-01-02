class Trie:
    class Node:
        def __init__(self, word = None):
            self.word = word
            self.child = {}

    def __init__(self):
        self.root = self.Node()

    def insert(self, floorInfos):
        cur = self.root
        for floorInfo in floorInfos:
            # if floorInfo in cur.child:
            #     cur.child[floorInfo] = self.Node(floorInfo)
            # cur = cur.child[floorInfo]
            cur = cur.child.setdefault(floorInfo, self.Node(floorInfo))

    def visualize(self, depth, node:Node):
        if node.word:
            print("--"*depth+node.word)
        curSortedChildrenKey = sorted(node.child.keys())
        for childKey in curSortedChildrenKey:
            self.visualize(depth+1, node.child[childKey])

import sys

input = sys.stdin.readline

trie = Trie()
for _ in range(int(input())):
    n, *words = list(input().strip().split())
    trie.insert(words)
trie.visualize(-1,trie.root)