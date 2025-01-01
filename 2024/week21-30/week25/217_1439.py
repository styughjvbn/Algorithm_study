n=input().strip()
split1=n.split("0")
split2=n.split("1")
count1=0
for i in split1:
    if i!='':
       count1+=1
count2=0
for i in split2:
    if i!="":
        count2+=1

print(min(count2,count1))