str1=input().strip()

length=1
for j in range(len(str1)):
    is_this = True
    start = j
    end = len(str1) - 1
    while start < end:
        if str1[start] == str1[end]:
            start += 1
            end -= 1
        else:
            is_this = False
            break
    if is_this:
        length = max(length,len(str1)-j)

print((len(str1)-length)*2+length)

