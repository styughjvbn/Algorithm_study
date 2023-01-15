import sys
input=sys.stdin.readline

n=int(input())
words=[]
max_len=0
for _ in range(n):
    words.append(input().strip())
    max_len=max(len(words[-1]),max_len)

#각 알파벳 당 자릿수에 따른 가중치를 모두 구한다.
#A가 만의 자리에서 한번 십의 자리에서 한번 나온다면 총 10010의 가중치를 가지게 된다.
per_index_alpabet=[[]for _ in range(max_len)]
alpabet_dic={}
for i in range(n):
    index=-1
    for j in range(len(words[i])-1,-1,-1):
        if words[i][j] not in alpabet_dic:
            alpabet_dic[words[i][j]]=0
        per_index_alpabet[index].append(words[i][j])
        index-=1
value=1
for i in range(len(per_index_alpabet)-1,-1,-1):
    for j in per_index_alpabet[i]:
        alpabet_dic[j]+=value
    value*=10

#알파벳끼리의 가중치를 비교하여 정렬한 후에 각 알파벳이 바뀔 숫자를 구한다.
num=9
for i in sorted(alpabet_dic.items(),key=lambda a:a[1],reverse=True):
    alpabet_dic[i[0]]=num
    num-=1
#문자들의 알파벳들을 알맞은 숫자로 바꾸고 최종 합을 계산한다.
result=0
for i in range(n):
    disit=1
    for j in range(len(words[i])-1,-1,-1):
        result+=alpabet_dic[words[i][j]]*disit
        disit*=10
print(result)
