# 돈 종류 미리 준비
moneyList = [50000, 10000, 5000, 1000, 500, 100, 50, 10]

# t, test_case
t = int(input())
for test_case in range(1, t+1):
    inputMoney = int(input()) # 거슬러줘야 할 금액 N
    changeLIst = [0]*8 # 거슬러주는 돈의 종류와 갯수, List
    for i in range(len(changeLIst)):
        changeLIst[i] = inputMoney // moneyList[i]
        inputMoney %= moneyList[i]
    print(f"#{test_case}")
    print(*changeLIst)