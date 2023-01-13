def get_divisor(n):
    lstS = []
    lstL = []
    for i in range(1, int(n**(1/2))+1):
        if n%i == 0:
            lstS.append(i)
            if i != n//i:
                lstL.append(n//i)
    return lstS + lstL[::-1]

print(*get_divisor(int(input())))