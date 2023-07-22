n=int(input())
words=[]
for i in range(n):
    words.append(input().strip())
cost={}
for i in words:
    for idx,char in enumerate(i,1):
        if cost.get(char):
            cost[char]+=10**(len(i)-idx)
        else:
            cost[char]= 10 ** (len(i) - idx)
sorted_cost=sorted(cost.items(),key=lambda a:a[1],reverse=True)
result=0
number=9
for i in sorted_cost:
    result+=i[1]*number
    number-=1
print(result)