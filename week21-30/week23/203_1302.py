import sys
input=sys.stdin.readline

n=int(input())
dic={}
result=["~",0]
for i in range(n):
    book=input().strip()
    if book in dic:
        dic[book]+=1
    else:
        dic[book]=1
    if dic[book]>result[1]:
        result = [book, dic[book]]
    elif dic[book]==result[1]:
        if book<result[0]:
            result=[book,dic[book]]
print(result[0])