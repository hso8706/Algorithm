primeN = [2,3,5,7,11]
T = int(input())
for test_case in range(1, T+1):
    num = int(input())
    result = [0,0,0,0,0]
    for i in range(len(primeN)):
        while num % primeN[i] ==0:
            num /= primeN[i]
            result[i] += 1
    print("#%d"%test_case, *result)
