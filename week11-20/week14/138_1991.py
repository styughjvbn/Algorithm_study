import sys


n=int(sys.stdin.readline())

graph={}
for i in range(n):
    temp=list(sys.stdin.readline().split())
    graph[temp[0]]=[temp[1],temp[2]]

def inorder(n):
    if  graph[n][0]!='.':
        inorder(graph[n][0])
    print(n,end='')
    if graph[n][1] != '.':
        inorder(graph[n][1])

def backorder(n):
    if  graph[n][0]!='.':
        backorder(graph[n][0])
    if graph[n][1] != '.':
        backorder(graph[n][1])
    print(n,end='')

def firstorder(n):
    print(n,end='')
    if  graph[n][0]!='.':
        firstorder(graph[n][0])
    if graph[n][1] != '.':
        firstorder(graph[n][1])
firstorder('A')
print()
inorder('A')
print()
backorder('A')
