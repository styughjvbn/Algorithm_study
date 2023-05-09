import sys
input=sys.stdin.readline

t=int(input())

def solution(phone_book,n):
    phone_book.sort()
    for i in range(n-1):
        flag=False
        if len(phone_book[i])>len(phone_book[i+1]):
            flag=True
        else:
            for j in range(len(phone_book[i])):
                if phone_book[i][j]!=phone_book[i+1][j]:
                    flag=True
        if not flag:
            return False
    return True

for i in range(t):
    n=int(input())
    arr=[]
    for j in range(n):
        arr.append(input().strip())
    if solution(arr,n):
        print("YES")
    else:
        print("NO")
