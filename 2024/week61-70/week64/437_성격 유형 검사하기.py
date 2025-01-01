def calc_score(survey_type,choice,category,reverse=False):
    choice=choice-4
    if not reverse:
        if choice>0:
            category[survey_type][1]+=abs(choice)
        else:
            category[survey_type][0]+=abs(choice)
    else:
        if choice>0:
            category[survey_type][0]+=abs(choice)
        else:
            category[survey_type][1]+=abs(choice)
    return category

def solution(survey, choices):
    answer = ''
    category={
        "RT":[0,0],
        "CF":[0,0],
        "JM":[0,0],
        "AN":[0,0]
    }
    for i,j in zip(survey,choices):
        if i== "AN" :
            category=calc_score("AN",j,category)
        elif i=="NA":
            category=calc_score("AN",j,category,True)
        elif i=="CF":
            category=calc_score("CF",j,category)
        elif i=="FC":
            category=calc_score("CF",j,category,True)
        elif i== "RT":
            category=calc_score("RT",j,category)
        elif i== "TR":
            category=calc_score("RT",j,category,True)
        elif i== "JM":
            category=calc_score("JM",j,category)
        elif i== "MJ":
            category=calc_score("JM",j,category,True)
    for i,j in category.items():
        if j[0]>=j[1]:
            answer+=i[0]
        elif j[0]<j[1]:
            answer+=i[1]
    print(category)
    return answer