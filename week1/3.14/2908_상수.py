s = input().split()

reversed_s0 = ''.join(reversed(s[0]))
reversed_s1 = ''.join(reversed(s[1]))
print(max(int(reversed_s0),int(reversed_s1)))
