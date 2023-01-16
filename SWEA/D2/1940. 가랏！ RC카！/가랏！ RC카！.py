'''
Todo
1. 초기 속도==0 m/s, 최저 속도==0 m/s(0에서 더 감속되더라도 음수가 되진 않는다.)
2. 입력(a,b)
    속도 종류 // 0: 현재 속도 유지, 1: 가속, 2: 감속
    속도 크기

- 문제
: command에 2개의 숫자가 들어올 때랑, 1개의 숫자(=0)이 들어올 때를 구분하지 못해서 난관 봉착
=> try - except 구문으로 해결
'''

T = int(input())
for test_case in range(1, T+1):
    sec = int(input())
    distance = 0
    vSpeed = 0
    for s in range(1, sec+1):
        try:
            iType, iSpeed = map(int, input().split())
        except ValueError:
            iType, iSpeed = 0, 0
        if iType == 1:
            vSpeed += iSpeed
        elif iType == 2:
            if vSpeed - iSpeed < 0:
                vSpeed = 0
            else: vSpeed -= iSpeed
        distance += vSpeed
    print("#%d"%test_case, distance)
