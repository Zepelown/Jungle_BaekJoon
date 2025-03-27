numbers = list()
for i in range(9):
    numbers.append(int(input()))
max_num = max(numbers)

print(max_num)
print(numbers.index(max_num,0,numbers.__sizeof__())+1)
