import sys

input_str=sys.stdin.readline().strip()
alpabet=[[0 for j in range(len(input_str)+1)] for i in range(26)]
q_count=int(sys.stdin.readline().strip())

#알파벳의 아스키코드를 이용하여 알파벳들의 위치를 저장한다.
for k in range(len(input_str)):
    alpabet[ord(input_str[k])-97][k+1]=1

#알파벳의 아스키코드를 이용하여 알파벳들의 prefix count를 구한다.
for a in range(26):
    for j in range(len(input_str)):
        alpabet[a][j+1]=alpabet[a][j]+alpabet[a][j+1]

#출력한다.
for b in range(q_count):
    c,start,end=sys.stdin.readline().split()
    print(alpabet[ord(c)-97][int(end)+1]-alpabet[ord(c)-97][int(start)])