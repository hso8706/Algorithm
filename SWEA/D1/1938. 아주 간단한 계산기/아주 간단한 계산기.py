import math
a, b = map(int, input().split())
if b == 0:
    print("b는 0일 수 없습니다.")
else :
    print(a+b)
    print(a-b)
    print(a*b)
    print(math.trunc(a/b))