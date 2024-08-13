import math


def exgcd(a: int, mod: int) -> tuple:
    '''
    利用扩展欧几里得算法求解模逆元
    ax - by \equiv 1
    '''
    if mod == 0:
        x = 1
        y = 0
        return x, y

    x1, y1 = exgcd(mod, a % mod)
    x = y1
    y = x1 - (a // mod) * y1
    return x, y


def decrypt(ciphertext: str, a_invert: int, b: int) -> str:
    plaintext = []
    for ch in ciphertext:
        plaintext.append(chr((a_invert * (ord(ch) - 65 - b)) % space + 65))
    return ''.join(plaintext)


'''
找密钥，a的取值是与空间大小互素的数（12个），b可取空间内所有数（26个）
'''
space = 26

a = [mutually_prime for mutually_prime in range(
    1, space) if math.gcd(mutually_prime, space) == 1]
b = [number for number in range(1, 27)]
a_invert = [exgcd(a_ori, space)[0] for a_ori in a]

ciphertext = 'KQEREJEBCPPCJCRKIEACUZBKRVPKRBCIBQCARBJCVFCUPKRIOFKPACUZQEPBKRXPEIIEABDKPBCPFCDCCAFIEABDKPBCPFEQPKAZBKRHAIBKAPCCIBURCCDKDCCJCIDFUIXPAFFERBICZDFKABICBBENEFCUPJCVKABPCYDCCDPKBCOCPERKIVKSCPICBRKIJPKABI'


for index, decrypt_a in enumerate(a_invert):
    for decrypt_b in b:
        print('Current a = {0}, a_invert = {1}, b = {2}:'.format(
            a[index], decrypt_a, decrypt_b))
        print(decrypt(ciphertext, decrypt_a, decrypt_b))


'''
Result: OCANADATERREDENOSAIEUXTONFRONTESTCEINTDEFLEURONSGLORIEUXCARTONBRASSAITPORTERLEPEEILSAITPORTERLACROIXTONHISTOIREESTUNEEPOPEEDESPLUSBRILLANTSEXPLOITSETTAVALEURDEFOITREMPEEPROTEGERANOSFOYERSETNOSDROITS
'''
