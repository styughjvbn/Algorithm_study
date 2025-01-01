class Node:
    def __init__(self, character, endOfWord = False):
        self.endOfWord = endOfWord
        self.child = {}
        self.chracter = character

class Trie:
    def __init__(self):
        self.root = Node("")
    
    def insert(self, word):
        curNode = self.root
        for chracter in word:
            if chracter not in curNode.child:
                newNode = Node(chracter)
                curNode.child[chracter]=newNode
            curNode = curNode.child[chracter]
        curNode.endOfWord = True
    
    def find(self, word):
        curNode = self.root
        for chracter in word:
            if chracter not in curNode.child:
                return False
            curNode = curNode.child[chracter]
        if not curNode.endOfWord:
            return False
        
        return True
    
    def printTrie(self, node:Node, depth):
        print(depth*"-"+node.chracter+"|"+str(node.endOfWord))
        if len(node.child) > 0:
            for _, childNode in node.child.items():
                self.printTrie(childNode,depth+1)

    def calcClickCount(self, node:Node, click):
        totalCount = 0
        if len(node.child) > 0:
            for _, childNode in node.child.items():
                if len(node.child) > 1 or node.endOfWord:
                    totalCount+= self.calcClickCount(childNode,click+1)
                else:
                    totalCount+= self.calcClickCount(childNode,click)
        if node.endOfWord:
            # print(click)
            totalCount+=click
        return totalCount
    
import sys

input = sys.stdin.readline

while True:
    try:
        n = int(input())
    except Exception as e:
        break
    trie = Trie()
    totalCount = 0
    for _ in range(n):
        trie.insert(input().strip())
    for _, childNode in trie.root.child.items():
        totalCount+= trie.calcClickCount(childNode, 1)
    # trie.printTrie(trie.root,0)
    # print(totalCount)
    print(f"{totalCount/n:.2f}")
