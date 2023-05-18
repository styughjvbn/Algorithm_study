def solution(n, arr1, arr2):
    answer = []
    map_1=[]
    map_2=[]
    for i in range(n):
        binary=str(bin(arr1[i]))[2:]
        binary=("0"*(n-len(binary)))+binary
        map_1.append(binary)
    for i in range(n):
        binary=str(bin(arr2[i]))[2:]
        binary=("0"*(n-len(binary)))+binary
        map_2.append(binary)
    for i in range(n):
        line=""
        for j in range(n):
            if map_1[i][j]=="0" and map_2[i][j]=="0":
                line+=" "
            else:
                line+="#"
        answer.append(line)
    return answer