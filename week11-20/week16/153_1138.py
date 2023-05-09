import sys

n = int(sys.stdin.readline())
arr = list(map(int,sys.stdin.readline().split()))
count=[[]for _ in range(n)]

for i in range(n):
    count[arr[i]].append(i+1)
result = count[0]

i=1
while len(result)!=n:
    if len(count[i])>0:
        for k in range(len(count[i])):
            bigger=0
            index=0
            for j in range(len(result)):
                if result[j]>count[i][k]:
                    bigger+=1
                    if bigger == i+1:
                        index = j
            if index==0:
                result.append(count[i][k])
            else:
                result.insert(index,count[i][k])


    i+=1
print(' '.join(map(str,result)),end="")