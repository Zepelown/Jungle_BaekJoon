hashmap = {str(i): 0 for i in range(10)}
result = 1

for _ in range(3):
    number = int(input())
    result *= number

for i in str(result):
    hashmap[i] += 1

for i in hashmap:
    print(hashmap[i])