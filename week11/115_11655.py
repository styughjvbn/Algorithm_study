import sys
from collections import deque

input_string=((sys.stdin.readline().rstrip()))
result=""
for i in range(len(input_string)):
    if input_string[i]==" ":
        result+=" "

    elif ord(input_string[i])<91:
        if ord(input_string[i])<58:
            result+=input_string[i]

        else:
            result += chr((((ord(input_string[i]) - 65) + 13) % 26) + 65)

    else:
        result+=chr((((ord(input_string[i])-97)+13)%26)+97)
print(result)