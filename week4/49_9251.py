import sys
#2차원 배열을 이용한 dp
string1=sys.stdin.readline().strip()
string2=sys.stdin.readline().strip()

arr=[[0 for _ in range(len(string1)+1)] for _ in range(len(string2)+1)]

for i in range(1,len(string2)+1):
    for j in range(1,len(string1)+1):
        if string2[i-1]==string1[j-1]:
            arr[i][j]=arr[i-1][j-1]+1
        else:
            arr[i][j]=max(arr[i][j-1],arr[i-1][j])

print(arr[len(string2)][len(string1)])