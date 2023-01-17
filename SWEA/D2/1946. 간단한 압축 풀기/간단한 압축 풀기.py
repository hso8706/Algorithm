T = int(input()) # Test_case
for test_case in range(1, T+1):
    n = int(input()) # 알파벳&갯수 쌍의 데이터 수(1 <= n <= 10)
    pairStr = ''
    resultStr = ''
    for i in range(n):
        pairData = input().split() # 알파벳+갯수의 값을 받는 list
        pairStr += pairData[0] * int(pairData[1])
    # pairStr = ''.join(sorted(pairStr))
    for s in range(0, len(pairStr), 10):
        # if s == len(pairStr)-1:
        #     resultStr += pairStr[s: s+10]
        resultStr += pairStr[s: s+10]+"\n"
    resultStr = resultStr[:len(resultStr)-1]
    print("#%d"%test_case)
    print(resultStr)
print("\n")




'''
1. 일렬로 쭉 받기
2. 10개씩 나누고 개행 시퀀스 첨가
'''