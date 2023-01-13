# P : A수도, 1리터당 요금
# Q : B수도, 기본 요금
# R : B수도, 기본 요금 한계(<=R)
# S : B수도, 1리터 당 초과 요금(>R)
# W : 종민이 사용 수도 양

T = int(input())
for test_case in range(1, T+1):
    p,q,r,s,w = map(int, input().split())
    wTaxA = p * w
    wTaxB = 0
    if w <= r: wTaxB = q
    else: wTaxB = q + s*(w-r)

    if wTaxA < wTaxB:
        print("#%d"%test_case, wTaxA)
    else :
        print("#%d"%test_case, wTaxB)