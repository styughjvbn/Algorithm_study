formula=input().strip()
plus=formula.split("-")
def eval(string):
    num=string.split("+")
    total=0
    for i in num:
        total+=int(i)
    return total

if len(plus)<2:
    print(eval(plus[0]))
else:
    result=eval(plus[0])
    for i in range(1,len(plus)):
        result-=eval(plus[i])
    print(result)