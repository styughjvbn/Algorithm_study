import sys

n=int(sys.stdin.readline())
flag=[1]*26
count=0
for _ in range(n):
    flag = [1] * 26
    word=sys.stdin.readline().strip()
    start=word[0]
    flag[ord(start)-97]=0
    i=1
    while i<len(word):
        if start==word[i]:
            i+=1
            continue
        else:
            if flag[ord(word[i])-97]:
                start = word[i]
                flag[ord(word[i]) - 97] = 0
                i += 1
            else:
                break
    if i==len(word):
        count+=1
    i=0

print(count)





