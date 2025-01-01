def solution(key, lock):
    hole_count = 0
    for line in lock:
        for i in line:
            if i == 0:
                hole_count += 1
    # original direction
    if check_lock(key, lock, hole_count):
        return True
    # rotate 90 degree
    key.reverse()
    rotate_90_key = list(zip(*key))
    if check_lock(rotate_90_key, lock, hole_count):
        return True

    # rotate 180 degree
    for i in key:
        i.reverse()
    if check_lock(key, lock, hole_count):
        return True

    # rotate 270 degree
    key.reverse()
    rotate_270_key = list(zip(*key))
    if check_lock(rotate_270_key, lock, hole_count):
        return True

    return False


def check_lock(key, lock, hole_count):
    outer_range = len(key) - 1
    lock_length = len(lock)
    for i in range(-outer_range, len(lock) + outer_range):
        for j in range(-outer_range, len(lock) + outer_range):
            temp_hole_count = hole_count
            flag = False
            for k in range(len(key)):
                if flag:
                    break
                for l in range(len(key)):
                    if 0 <= i + k < lock_length and 0 <= j + l < lock_length:
                        if key[k][l] + lock[i + k][j + l] == 1:
                            if lock[i + k][j + l] == 0:
                                temp_hole_count -= 1
                        else:
                            flag = True
                            break
            if temp_hole_count == 0:
                return True
    else:
        return False


def print_key(key):
    for i in key:
        print(*i)