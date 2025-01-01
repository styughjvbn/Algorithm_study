import sys
from itertools import combinations
input=sys.stdin.readline

n,m=map(int,input().split())
words=[]
for i in range(n):
    word=input().strip()
    temp=0b00000000000000000000000000
    for j in word:
        if j not in ['a', 'n' ,'t' ,'i' ,'c' ]:
            temp=temp|(0b1<<(ord(j)-96))
    words.append(temp)
# for i in range(n):
#     print(bin(words[i]),end=" ")

if m<5:
    print(0)
    exit()
else:
    alpabet=[]
    for i in range(26):
        if chr(i+97) not in ['a', 'n' ,'t' ,'i' ,'c' ]:
            alpabet.append(chr(i+97))
    case=list(combinations(alpabet,m-5))
    new_case=[]
    for i in range(len(case)):
        temp=0b0
        for j in case[i]:
            temp=temp|(0b1<<(ord(j)-96))
        new_case.append(temp)
    result=0
    for i in range(len(new_case)):
        temp_words=words[:]
        for k in range(n):
            temp_words[k]=temp_words[k]^(temp_words[k]&new_case[i])
        result=max(temp_words.count(0),result)
        # for i in range(n):
        #     print(bin(temp_words[i]), end=" ")
        # print()
    print(result)