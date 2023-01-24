t = int(input())

for test_case in range(1, t+1):
    char_list = list(input())
    char_list_reverse = []
    for i in range(len(char_list)-1, -1, -1):
        char_list_reverse.append(char_list[i])
    
    if char_list == char_list_reverse:
        print(f'#{test_case} 1')
    else:
        print(f'#{test_case} 0')