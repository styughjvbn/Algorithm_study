a,b=input().strip().split()

result=50

for i in range(len(b)-len(a)+1):
    temp_b=b[i:i+len(a)]
    temp_count=0
    for j in zip(a,temp_b):
        if j[0]!=j[1]:
            temp_count+=1
    result=min(result,temp_count)
print(result)