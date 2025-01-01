word=input().strip()

def check_pelindrom(word):
    for i in range(len(word) // 2):
        if word[i] != word[-(i + 1)]:
            return False
    else:
        return True
lenth=0
for i in range(len(word)):
    if check_pelindrom(word[i:]):
        lenth=max(lenth,len(word[i:]))
print((len(word)-lenth)*2+lenth)
