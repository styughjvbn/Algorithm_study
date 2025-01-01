import sys

line=sys.stdin.readline().strip()
line=line.lower()
alpabet=[0]*30
for i in line:
    alpabet[ord(i)-97]+=1
result=-1
count=0
for i in alpabet:
    if result<i:
        result=i
        count=0
    elif result==i:
        count+=1
if count==0:
    print(chr(alpabet.index(result)+97).upper())
else:
    print("?")

# list 내장함수 count 활용
# x = input().upper()
# unx = list(set(x))
# count = []
# for i in unx:
#     count.append(x.count(i))
# if count.count(max(count)) >1:
#     print("?")
# else:
#     print(unx[count.index(max(count))])