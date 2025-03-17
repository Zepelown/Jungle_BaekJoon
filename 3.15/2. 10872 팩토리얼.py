dp = {}

num = int(input())

def factor(n):
    if n in dp:
        return dp[n]
    if n == 1 or n == 0:
        return 1
    dp[n] = n * factor(n-1)
    return dp[n]

print(factor(num))



# num = int(input())
#
# result = 1
# for i in range(1,num+1):
#     result *= i
# print(result)