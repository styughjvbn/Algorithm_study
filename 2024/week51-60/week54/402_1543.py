import re

string=input().strip()
pattern=input().strip()
print(len(re.findall(pattern,string)))