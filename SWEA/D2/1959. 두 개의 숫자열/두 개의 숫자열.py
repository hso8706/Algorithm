t = int(input())
for test_case in range(1, t+1):
    a_length, b_length = map(int, input().split())
    a_list = list(map(int, input().split()))
    b_list = list(map(int, input().split()))
    max = 0
    if a_length > b_length:
        for i in range(a_length-b_length):
            sum = 0
            for j in range(b_length):
                sum += a_list[j+i] * b_list[j]
            if max <= sum: max = sum
        print("#%d" % test_case, max)
    else:
        for i in range(b_length-a_length+1):
            sum = 0
            for j in range(a_length):
                sum += b_list[j+i] * a_list[j]
            if max <= sum: max = sum
        print("#%d" % test_case, max)