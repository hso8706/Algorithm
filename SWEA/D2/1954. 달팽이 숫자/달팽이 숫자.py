'''
- depth를 다루는 반복문
- x축을 다루는 반복문
- y축을 다루는 반복문
- 시작 좌표
- 방향을 바꾸는 변수
'''
t = int(input()) # 테스트 케이스
for test_case in range(1, t+1):
    n = int(input()) # 달팽이 크기
    snail = [[0]*n for i in range(n)] # 빈 달팽이 생성, 2차원 배열로 구현
    x, y = 0, -1 # 2차원 배열 시작 좌표
    trans = 1 # 방향 변수
    num = 1 # 할당될 값

    print("#%d" %test_case)
    while n > 0: # depth 반복문
        for i in range(n): # x 축 반복문
            y += trans
            snail[x][y] = num
            num += 1
        n -= 1 # 칸수 계산
        
        for i in range(n): # y 축 반복문
            x += trans
            snail[x][y] = num
            num += 1
        trans *= -1 # 방향 전환, 2줄 마다 변환

    for leng in range(len(snail)):
        print(*snail[leng])
