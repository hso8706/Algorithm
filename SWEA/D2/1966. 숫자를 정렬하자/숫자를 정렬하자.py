t = int(input())
for test_case in range(1, t+1):
    n = int(input()) # 테스트 케이스 당 받는 수의 갯수, 파이썬에선 큰 의미 없음
    lst = list(map(int, input().split()))
    lst.sort()
    print("#%d" %test_case, *lst)