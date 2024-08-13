import math

PI_inv = {
    0: 3, 1: 11, 2: 17, 3: 24, 4: 21, 5: 14, 6: 7, 7: 4, 8: 25, 9: 23, 10: 22,
    11: 15, 12: 19, 13: 1, 14: 6, 15: 5, 16: 9, 17: 16, 18: 13, 19: 12, 20: 20,
    21: 18, 22: 10, 23: 0, 24: 2, 25: 8
}


ciphertext = 'WRTCNRLDSAFARWKXFTXCZRNHNYPDTZUUKMPLUSOXNEUDOKLXRMCBKGRCCURR'


def decrypt(ciphertext: str, K: int) -> str:
    plaintext = []
    for index, ch in enumerate(ciphertext):
        plain_ch = (ord(ch) - 65) - (K + index) % 26
        if plain_ch < 0:
            plaintext.append(chr(PI_inv.get(26 + plain_ch) + 65))
        else:
            plaintext.append(chr(PI_inv.get(plain_ch) + 65))

    return ''.join(plaintext)


def main() -> None:
    for K in range(0, 26):
        print('Current K = {0}, the decrypted text is {1}.'.format(K, decrypt(ciphertext, K)))


if __name__ == '__main__':
    main()
