# t, test_case
t = int(input())
for test_case in range(1, t+1):
    # h1, m1, h2, m2 입력
    h1, m1, h2, m2 = map(int, input().split())
    h = h1 + h2
    m = m1 + m2
    if m > 60:
        h += 1
        m -= 60
    if h > 12 :
        h -= 12
    print(f"#{test_case}", h, m)