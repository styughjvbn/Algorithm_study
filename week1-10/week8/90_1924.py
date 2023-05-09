import sys

x,y=map(int,sys.stdin.readline().split())
day=0
for i in range(1,x):
    if i==2:
        day+=28
    elif i==4 or i==6 or i==9 or i==11:
        day+=30
    else:
        day+=31

day+=y
week=["SUN","MON", "TUE", "WED", "THU", "FRI", "SAT"]
print(week[day%7])