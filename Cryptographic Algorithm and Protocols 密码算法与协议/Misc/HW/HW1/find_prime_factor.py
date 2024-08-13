num = int(input())
prime_factor = []

for i in range(2, num):
    while True:
        if num % i == 0:
            num /= i
            prime_factor.append(i)
        else:
            break

print(prime_factor)