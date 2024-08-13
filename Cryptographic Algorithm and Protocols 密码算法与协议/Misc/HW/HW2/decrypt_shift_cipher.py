def decrypt(ciphertext, shift_count):
    plaintext = []
    for ch in ciphertext:
        if ord(ch) <= 90-shift_count:
            plaintext.append(chr(ord(ch)+shift_count))
        else:
            plaintext.append(chr(64+ord(ch)+shift_count-90))

    return plaintext


ciphertext1 = 'APNDJI'
ciphertext2 = 'XYGROBO'

print('Decrypt the ciphertext {}:'.format(ciphertext1))
for shift in range(1, 26):
    for ch in decrypt(ciphertext1, shift):
        print(ch, end='')
    print()

print('Decrypt the ciphertext {}:'.format(ciphertext2))
for shift in range(1, 26):
    for ch in decrypt(ciphertext2, shift):
        print(ch, end='')
    print()