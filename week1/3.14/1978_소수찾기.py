hashmap ={}

MAX = 1001

for i in range(MAX):
    hashmap[i] = True
hashmap[1] = False

for i in range(2, MAX + 1):
    for j in range(i*2, MAX + 1, i):
        hashmap[j] = False

result = 0
s = input()
numbers = map(int,input().split())
for i in numbers:
    if hashmap[i]:
        result +=1
print(result)

## 해쉬맵을 이용
