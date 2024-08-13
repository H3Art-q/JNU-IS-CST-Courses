import math


def find_order(p, a):
    n = 1
    while True:
        if pow(a, n, p) == 1:
            return n
        n += 1


def egcd(a, b):
    if a == 0:
        return b, 0, 1
    else:
        g, y, x = egcd(b % a, a)
        return g, x - (b // a) * y, y


def multiplicative_inverse(a, m):
    g, x, y = egcd(a, m)
    if g != 1:
        raise Exception('Modular inverse does not exist')
    return x % m


def shanks(p, a, b):
    n = find_order(p, a)
    m = math.ceil(math.sqrt(n))
    a_m = pow(a, m, p)

    giant_steps = {pow(a_m, j, p): j for j in range(m)}

    a_inv = multiplicative_inverse(a, p)
    for i in range(m):
        value = (b * pow(a_inv, i, p)) % p
        if value in giant_steps:
            return (m * giant_steps[value] + i) % n

    raise ValueError("Discrete logarithm not found")


if __name__ == "__main__":
    print(shanks(24691, 106, 12375))
    print(shanks(458009, 6, 248388))
