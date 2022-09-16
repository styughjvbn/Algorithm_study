import sys
import re

word=sys.stdin.readline().strip()
count=0
i=0
while i<len(word)-1:
    if word[i]=='c':
        if word[i+1]=='=' or word[i+1]=='-':
            count+=1
            i+=2
        else:
            count += 1
            i += 1
    elif word[i] == 'd':
        if word[i+1]=='-':
            count += 1
            i += 2
        elif word[i+1]=='z':
            if i+2<len(word) and word[i+2]=='=':
                count += 1
                i += 3
            else:
                count += 1
                i += 1
        else:
            count += 1
            i += 1
    elif word[i] == 'l':
        if word[i+1]=='j':
            count += 1
            i += 2
        else:
            count += 1
            i += 1
    elif word[i] == 'n':
        if word[i+1]=='j':
            count += 1
            i += 2
        else:
            count += 1
            i += 1
    elif word[i] == 's':
        if word[i+1]=='=':
            count += 1
            i += 2
        else:
            count += 1
            i += 1
    elif word[i] == 'z':
        if word[i+1]=='=':
            count += 1
            i += 2
        else:
            count += 1
            i += 1
    else:
        count += 1
        i += 1
if word[-1]=='-'or word[-1]=='=':
    print(count)
elif word[-1]=='j':
    if word[-2]=='l'or word[-2]=='n':
        print(count)
    else:
        print(count+1)
else:
    print(count+1)
