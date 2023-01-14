table = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','+','/' ]

T = int(input())
for test_case in range(1, T+1):
    encodedStr = list(input())
    binStr = ''
    decodedStr = ''
    for s in encodedStr:
        binStr += str(bin(table.index(s))).lstrip('0b').zfill(6)
    for i in range(len(binStr)//8):
        decodedStr += chr(int('0b'+binStr[8*i:8*(i+1)], 2))
    print("#%d"%test_case, decodedStr)
'''
TODO
1. 인코딩된 문자열 받기
2. 받은 문자열을 문자로 분리하기
3. 각각의 문자를 표1의 숫자로 변환하기
4. 변환한 숫자들을 2진수화하기(6bit짜리로 변환될 예정; 0~63)
5. 2진수화한 숫자들을 한줄로 이어붙이기(아마 str)
6. 8bit를 기준으로 `5`의 수를 나누고 10진수로 변경하기
7. 각각의 10진수의 수를 아스키코드 값으로 인식하고 문자로 변경하기
8. 변경된 문자를 합쳐서 문자열로 출력하기
'''