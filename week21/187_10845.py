from collections import deque
import sys

input=sys.stdin.readline

n=int(input())

queue=deque()
for i in range(n):
    arr=list(input().split())
    if arr[0]=="push":
        queue.append(int(arr[1]))
    if arr[0] == "front":
        if len((queue)):
            print(queue[0])
        else:
            print(-1)
    if arr[0] == "back":
        if len((queue)):
            print(queue[-1])
        else:
            print(-1)
    if arr[0] == "size":
        print(len((queue)))
    if arr[0] == "empty":
        if len((queue)):
            print(0)
        else:
            print(1)
    if arr[0] == "pop":

        if len((queue)):
            print(queue.popleft())
        else:
            print(-1)