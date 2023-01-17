'''
1. t 입력
2. 공백으로 분리된 4개의 숫자 입력(월1, 일1, 월2, 일2)
=> `월1/일1`부터 `월2/일2`까지 일수 차이 구하기
1. (월1)부터 (월2-1)까지 for문 순회를 통하여 dict_values 더하기
2. 월1에 해당한 요일 수 차감
3. 월2에 해당한 요일 수 추가
'''

dict_calender = {1:31, 2:28, 3:31, 4:30, 5:31, 6:30, 7:31, 8:31, 9:30, 10:31, 11:30, 12:31}

t = int(input())
for test_case in range(1, t+1):
    result = 0
    month_1, day_1, month_2, day_2 = map(int, input().split())
    for m in range(month_1,month_2):
        result += dict_calender[m]
    result += day_2 - day_1 +1
    print("#%d"%test_case, result)
