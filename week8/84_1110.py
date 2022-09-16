import sys

n=sys.stdin.readline().strip()
base=n
count=0
while True:
    if len(n)<2:
        n='0'+n
    new_num=n[1]+str(int(n[0])+int(n[1]))[-1]
    count+=1
    if int(new_num)==int(base):
        print(count)
        break
    n=new_num
