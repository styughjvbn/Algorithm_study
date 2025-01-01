def solution(expression):
    answer = 0
    expression=expression.replace("+","|+|")
    expression=expression.replace("*","|*|")
    expression=expression.replace("-","|-|")
    expression_list=expression.split("|")
    print(expression_list)

    comb=[
        ['+','-','*'],
        ['+','*','-'],
        ['-','+','*'],
        ['-','*','+'],
        ['*','-','+'],
        ['*','+','-'],
    ]
    for i in comb:
        expression_list=expression.split("|")
        for j in i:
            k=0
            while k<len(expression_list):
                if expression_list[k]==j:
                    oper1=expression_list[k-1]
                    oper2=expression_list[k+1]
                    eval_result=str(eval(oper1+j+oper2))
                    expression_list[k]=eval_result
                    expression_list.pop(k+1)
                    expression_list.pop(k-1)
                    k-=2
                k+=1
        answer=max(abs(int(expression_list.pop())),answer)
    return answer