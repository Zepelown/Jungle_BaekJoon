"""
일단 문제를 풀기 위해서 소수를 찾는다
소수는 해시맵을 사용하는 기법으로 배수들을 반복문으로 다 제거해서 소수만 남기는 방식이다.
그렇게 소수는 구했다치면 두 소수의 차이가 가장 작은 것을 출력이 문제가 된다.
-> 이 방법을 에라토스테네스의 체라고 한다!


**차이가 작은 것을 출력하는 방법**
여기선 노가다로 했다.
이분탐색의 컨셉을 좀 빌려와서 중간으로 짜른 다음 오른쪽 왼쪽으로 보낸다.
여기서 이제 가까운 소수라고 하더라도 합이 맞지 않는 경우가 있다.
이럴 땐 상황에 맞춰서 왼쪽을 더 진행하거나, 오른쪽을 진행해야 한다.
이 판단은 현재 두 값의 합으로 할 수 있다.
만약, 값이 크다면 값을 줄여야 하므로 왼쪽으로 더 간다.
반대로, 값이 작다면 값을 키워야 하므로 오른쪽으로 더 간다.

그렇게 답을 구할 수가 있다.
"""

hashmap = {}
MAX = 10000
for i in range(MAX):
    hashmap[i] = True
hashmap[1] = False

for i in range(2,MAX+1):
    for j in range(i*2, MAX + 1, i):
        hashmap[j] = False

t = int(input())

for _ in range(t):
    num = int(input())
    middle = num // 2

    left = middle
    right = middle

    while True:
        if hashmap[left] == True and hashmap[right] == True:
            if left + right > num:
                left -=1
                continue
            if left + right < num:
                right += 1
                continue
            break
        if not hashmap[left]:
            left -=1
        if not hashmap[right]:
            right +=1

    print(f"{left} {right}")

