import sys

input = sys.stdin.readline

n = int(input())
budgetReqs = list(map(int, input().split()))
totalBudget = int(input())

minBoundary = 1
maxBoundary = max(budgetReqs)
midBoundary = (minBoundary + maxBoundary) // 2
result = midBoundary
while minBoundary <= maxBoundary:
    midBoundary = (minBoundary + maxBoundary) // 2
    sumBudgetReq = 0
    for budgetReq in budgetReqs:
        sumBudgetReq += min(budgetReq, midBoundary)
    if sumBudgetReq <= totalBudget:
        minBoundary = midBoundary +1
        result = midBoundary
    else:
        maxBoundary=midBoundary-1
print(result)