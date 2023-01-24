# custom round() 함수 : 부동소수점 문제를 해결
def round_perfect(n, point = 0):
    a = n * (10 ** point)
    result = int(a) + (1 if (a - int(a)) >= 0.5 else 0)
    return result / (10 ** point)

t = int(input())

for test_case in range(1, t+1):
    int_list = list(map(int, input().split())) # 10개의 수 입력

    max_n = int_list[0] # 최대 수 할당 변수
    min_n = int_list[0] # 최소 수 할당 변수
    sum_list = 0 # 리스트의 총합
    # 최대 수, 최소 수 파악 로직 + 10개의 모든 수의 총합
    for i in int_list:
        if max_n < i : max_n = i
        if min_n > i : min_n = i
        sum_list += i
    sum_list -= max_n + min_n
    avg_middle = int(round_perfect(sum_list / 8))
    print(f'#{test_case} {avg_middle}')
