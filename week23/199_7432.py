import sys

input=sys.stdin.readline

n=int(input())

class Trie():
    def __init__(self):
        self.head={}

    def insert(self,strings):
        cur=self.head
        for word in strings:
            if word not in cur:
                cur[word]={}
            cur=cur[word]
        cur[0]=True

    def print(self,node,space):
        if 0 in node:
            if len(node)==1:
                return
            else:
                del node[0]
        cur=sorted(node)
        for word in cur:
            print(" "*int(space) + word)
            self.print(node[word],int(space)+1)

trie=Trie()
for i in range(n):
    strings=(input().strip().split("\\"))
    trie.insert(strings)

trie.print(trie.head,0)

