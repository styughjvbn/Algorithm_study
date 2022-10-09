import sys

n,l=map(int,sys.stdin.readline().split())

input_map=[[0for _ in range(n)]for _ in range(n)]
rotated_input_map=[[0for _ in range(n)]for _ in range(n)]
list_set=[input_map,rotated_input_map]

for i in range(n):
    tmp_list=list(map(int,sys.stdin.readline().split()))
    for j in range(n):
        input_map[i][j]=tmp_list[j]
        rotated_input_map[j][i]=tmp_list[j]
result=0
for q in range(2):
    input_map=list_set[q]
    runway = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        is_possible=True
        flag=True
        for j in range(0,n-1):
            if input_map[i][j+1]!=input_map[i][j]:
                if abs(input_map[i][j+1]-input_map[i][j])>1:
                    is_possible=False
                    break
                elif (input_map[i][j+1]-input_map[i][j])==1:#앞에 높이가 1만큼 높다
                    temp=True
                    if runway[i][j]==1:
                        is_possible = False
                        temp = False
                    else:
                        for k in range(1,l):
                            if j-k<0 or input_map[i][j]!=input_map[i][j-k]or runway[i][j-k]==1:
                                is_possible=False
                                temp=False
                                break
                    if temp:
                        for a in range(l):
                            runway[i][j-a]=1
                elif (input_map[i][j+1]-input_map[i][j])==-1:
                    temp = True
                    if runway[i][j+1]==1:
                        is_possible = False
                        temp = False
                    else:
                        for k in range(1,l):
                            if j+1+k>n-1 or input_map[i][j+1]!=input_map[i][j+1+k]or runway[i][j+1+k]==1:
                                is_possible=False
                                temp = False
                                break
                    if temp:
                        for a in range(l):
                            runway[i][j+1+ a] = 1
        if is_possible:
            # for a in range(n):
            #     print(*runway[a])
            result+=1
print(result)