import sys
input=sys.stdin.readline

N,M=map(int,input().split())

result=""
words=[]
count=0
for i in range(N):
    words.append(input().strip())

for i in range(M):
    dic={}
    for j in range(N):
        if words[j][i] in dic:
            dic[words[j][i]]-=1
        else:
            dic[words[j][i]]=-1
    a=sorted(dic.items(),key=lambda a:(a[1],a[0]))
    result+=a[0][0]
    count+=N+a[0][1]

print(result)
print(count)