# 테스트 케이스 입력
t = int(input())
for test_case in range(1, t+1):
    # 행렬 크기 입력 (n * n)
    n = int(input())
    square = []
    # 행렬 값 입력
    for i in range(n):
        square.append(list(map(int, input().split())))
    # 결과 출력 string list
    result = [[]*n for i in range(n)]
    idx = 0 # result idx 초기화

    # 90도, 180도, 270도 회전 => 각 회전의 요소별로 더해서 출력해야함
    # 90도
    for j in range(n):
        for a in range(n-1, -1, -1):
            result[idx] += str(square[a][j])
        result[idx] += " "
        idx += 1
    idx = 0 # idx 초기화
    # 180도
    for k in range(n-1, -1, -1):
        for b in range(n-1, -1, -1):
            result[idx] += str(square[k][b])
        result[idx] += " "
        idx += 1
    idx = 0 # idx 초기화
    # 270도
    for l in range(n-1, -1, -1):
        for c in range(n):
            result[idx] += str(square[c][l])
        idx += 1
    idx = 0
    # 출력
    print("#%d" %test_case)
    for i in range(len(result)):
        print("".join(result[i]))
