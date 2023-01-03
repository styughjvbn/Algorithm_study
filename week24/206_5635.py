n=int(input())

birth=[]
for i in range(n):
    info=input().strip().split()
    day=info[1]
    if len(day)==1:
        day='0'+day
    month=info[2]
    if len(month)==1:
        month="0"+month
    number=info[3]+month+day
    birth.append([int(number),info[0]])

birth.sort(key=lambda a:a[0])

print(birth[-1][1])
print(birth[0][1])