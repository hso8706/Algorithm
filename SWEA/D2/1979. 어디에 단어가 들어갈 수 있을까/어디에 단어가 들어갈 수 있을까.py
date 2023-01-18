# t, test_case
t = int(input())
for test_case in range(1, t+1):
    # n: (nxn) 크기 / k: 단어의 길이
    n, k = map(int, input().split())
    # puzzle, 빈 list 생성
    puzzle = []
    # puzzle에 k가 들어갈 수 있는 공간 카운트
    cnt_result = 0
    # 퍼즐 칸 입력
    for i in range(n):
        puzzle.append(list(map(int, input().split())))
    # row_check
    for i in range(n):
        cnt_temp = 0 # 한 줄에 연속된 칸을 확인하기위한 카운트
        for j in range(n):
            if puzzle[i][j] == 1:
                cnt_temp += 1
                if j == n-1 and cnt_temp == k:
                    cnt_result += 1
            elif puzzle[i][j] == 0 and cnt_temp == k:
                cnt_result += 1
                cnt_temp = 0
            elif puzzle[i][j] == 0 and cnt_temp != k:
                cnt_temp = 0
    # col_check
    for i in range(n):
        cnt_temp = 0
        for j in range(n):
            if puzzle[j][i] == 1:
                cnt_temp += 1
                if j == n-1 and cnt_temp == k:
                    cnt_result += 1
            elif puzzle[j][i] == 0 and cnt_temp == k:
                cnt_result += 1
                cnt_temp = 0
            elif puzzle[j][i] == 0 and cnt_temp != k:
                cnt_temp = 0
    print(f"#{test_case}", cnt_result)
