import math
def solution(str1, str2):
    answer = 0
    set_str1={}
    set_str2={}
    for i in range(len(str1)-1):
        if str1[i].isalpha() and str1[i+1].isalpha():
            string=str1[i].lower()+str1[i+1].lower()
            if set_str1.get(string):
                set_str1[string]+=1
            else:
                set_str1[string]=1
    for i in range(len(str2)-1):
        if str2[i].isalpha() and str2[i+1].isalpha():
            string=str2[i].lower()+str2[i+1].lower()
            if set_str2.get(string):
                set_str2[string]+=1
            else:
                set_str2[string]=1
    set1_str1_str2=set(set_str1.keys())&set(set_str2.keys())
    set2_str1_str2=set(set_str1.keys())|set(set_str2.keys())
    print(set2_str1_str2)
    intersection=0
    union=0
    for i in set1_str1_str2:
        intersection+=min(set_str1[i],set_str2[i])
    for i in set2_str1_str2:
        if set_str1.get(i) and set_str2.get(i):
            union+=max(set_str1.get(i),set_str2.get(i))
        else:
            if set_str1.get(i):
                union+=set_str1.get(i)
            else:
                union+=set_str2.get(i)
    if union!=0:
        answer=math.floor((intersection/union)*65536)
    else:
        answer=65536
    return answer