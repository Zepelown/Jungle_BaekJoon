"""
좀 어이 없긴 하지만, 1자리 , 10자리는 전부 다 한수이다.
그렇다.
"""

dp = {}

def check(num):
    first = num // 100  # 백의 자리
    second = (num // 10) % 10  # 십의 자리
    last = num % 10  # 일의 자리

    if second - first == last - second:
        dp[num] = dp[num-1] + 1
    else:
        dp[num] = dp[num-1]

for i in range(1001):
    if i < 100:
        dp[i] = i
    else:
        check(i)

number = int(input())
print(dp[number])
