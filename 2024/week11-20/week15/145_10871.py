import sys

n,x=map(int,sys.stdin.readline().split())

temp=list(map(int,sys.stdin.readline().split()))
for i in temp:
    if i<x:
        print(i,end=" ")