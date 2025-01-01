import sys
#-연산자 사이의 연산들에 괄호를 지정해준다.
#-연산자를 기준으로 수식을 쪼갠다.
exp=sys.stdin.readline().strip().split('-')
#쪼갠 수식들을 계산한다.
for i in range(len(exp)):
    exp[i]=sum(list(map(int,exp[i].split('+'))))
#맨 처음 수식에서 나머지 수식의 값을 뺀다.
if len(exp)<2:
    print(exp[0])
else:
    print(exp[0]-sum(exp[1:]))