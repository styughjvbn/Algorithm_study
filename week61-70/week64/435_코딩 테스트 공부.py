def solution(alp, cop, problems):
    max_alp_req, max_cop_req = 0, 0

    for problem in problems:
        max_alp_req = max(max_alp_req, problem[0])
        max_cop_req = max(max_cop_req, problem[1])

    dp = [[301] * (max_cop_req+1) for _ in range(max_alp_req+1)]

    alp = min(alp, max_alp_req)
    cop = min(cop, max_cop_req)

    dp[alp][cop] = 0
    problems.append([0,0,1,0,1])
    problems.append([0,0,0,1,1])
    for i in range(alp, max_alp_req+1):
        for j in range(cop, max_cop_req+1):
            for alp_req, cop_req, alp_rwd, cop_rwd, cost in problems:
                if i >= alp_req and j >= cop_req:
                    new_alp = min(i+alp_rwd, max_alp_req)
                    new_cop = min(j+cop_rwd, max_cop_req)
                    dp[new_alp][new_cop] = min(dp[new_alp][new_cop], dp[i][j] + cost)

    return dp[max_alp_req][max_cop_req]