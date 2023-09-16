from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    cur_weight=0
    cur_truck=0
    second=0
    truck_idx=0
    bridge=deque()
    while True:
        if truck_idx==len(truck_weights) and len(bridge)==0:
            break
        second+=1
        if len(bridge)>0 and bridge[0][1]+bridge_length<=second:
            exit_truck=bridge.popleft()
            cur_weight-=truck_weights[exit_truck[0]]
            cur_truck-=1
        if truck_idx>=len(truck_weights) or cur_weight+truck_weights[truck_idx] >weight or cur_truck+1>bridge_length:
            pass
        else:
            bridge.append([truck_idx,second])
            cur_weight+=truck_weights[truck_idx]
            cur_truck+=1
            truck_idx+=1

    return second