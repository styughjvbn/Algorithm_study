import math
number=input().strip()
num_dic=[0]*10
for i in number:
    num_dic[int(i)]+=1
sixnine=math.ceil((num_dic[6]+num_dic[9])/2)
num_dic[6]=sixnine
num_dic[9]=sixnine
print(max(num_dic))