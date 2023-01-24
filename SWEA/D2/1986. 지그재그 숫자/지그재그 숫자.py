t = int(input())

for test_case in range(1, t+1):
    n = int(input())
    sum_n = 0
    for i in range(1, n+1):
        if i % 2 == 1:
            sum_n += i
        else:
            sum_n += -i
    print(f'#{test_case} {sum_n}')