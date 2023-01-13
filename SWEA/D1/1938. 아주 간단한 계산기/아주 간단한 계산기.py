a, b = map(int, input().split())
if b == 0:
    print("b는 0일 수 없습니다.")
else :
    for i in [a+b, a-b, a*b, a//b]:
        print(i)
