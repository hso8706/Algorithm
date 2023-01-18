# t, test_case
t = int(input())
for test_case in range(1, t+1):
    sdoku = [] 
    sdoku_checker = 1 # 1: 겹침 없음. 2: 겹침 있음
    for i in range(9):
        sdoku.append(list(map(int, input().split())))
        if sum(sdoku[i]) != 45 : sdoku_checker = 0 # row_check
    # col_check
    for i in range(9):
        temp_sum = 0
        for j in range(9):
            temp_sum += sdoku[j][i]
        if temp_sum != 45:
            sdoku_checker = 0
            break
    # section_check
    for i in range(3):
        for j in range(3):
            temp_sum = 0
            for k in range(3):
                for l in range(3):
                    temp_sum += sdoku[i*3+k][j*3+l]
            if temp_sum != 45:
                sdoku_checker = 0
                break
    # 출력
    print(f'#{test_case}', sdoku_checker)