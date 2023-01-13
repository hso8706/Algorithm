# T: test_case
# n: 양의 수
# result: 본 숫자를 담는 list
    # n의 배수에서 각 자릿수에 해당하는 수를 result에 넣되, 중복되는 숫자는 담지 않는다.
# cnt = 카운트 횟수, 출력될 결과값

# control = [0,1,2,3,4,5,6,7,8,9]
T = int(input())
for test_case in range(1, T+1):
    n = int(input())
    result = []
    cnt = 0 
    # while result != control:
    while len(result) < 10:
        cnt += 1
        for i in list(map(int, str(n*cnt))):
            if i not in result:
                result.append(i)
    print("#%d"%test_case, cnt*n)