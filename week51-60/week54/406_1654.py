import sys

input=sys.stdin.readline
k,n=map(int,input().split())
lan=[ int(input()) for _ in range(k)]

top=max(lan)+1
bottom=0
middle=(top+bottom)//2
result=0
while top>bottom+1:
    num_of_lan=0
    for i in lan:
        num_of_lan+=i//middle
    # print(top, middle, bottom, num_of_lan)
    #너무 길게 잘랐을 때
    if num_of_lan<n:
        top=middle
        middle=(top+bottom)//2
    #너무 짧게 잘라서 k개 이상 만들었을 때
    else:
        result = max(result,middle)
        bottom = middle
        middle = (top + bottom) // 2
print(result)
