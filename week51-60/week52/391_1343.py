string=input().strip()
string=string.replace("XXXX","AAAA").replace("XX","BB")
if "X" in string:
    print(-1)
else:
    print(string)