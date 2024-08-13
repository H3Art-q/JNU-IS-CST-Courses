def decrypt(ciphertext, shift_count):
    plaintext = []
    for ch in ciphertext:
        if ord(ch) <= 90-shift_count:
            plaintext.append(chr(ord(ch)+shift_count))
        else:
            plaintext.append(chr(64+ord(ch)+shift_count-90))

    return plaintext


ciphertext = 'KCCPKBGUFDPHQTYAVINRRTMVGRKDNBVFDETDGILTXRGUDDKOTFMBPVGEGLTGCKQRACQCWDNAWCRXIZAKFTLEWRPTYCQKYVXCHKFTPONCQQRHJVAJUWETMCMSPKQDYHJVDAHCTRLSVSKCGCZQQDZXGSFRLSWCWSJTBHAFSIASPRJAHKJRJUMVGKMITZHFPDISPZLVLGWTFPLKKEBDPGCEBSHCTJRWXBAFSPEZQNRWXCVYCGAONWDDKACKAWBBIKFTIOVKCGGHJVLNHIFFSQESVYCLACNVRWBBIREPBBVFEXOSCDYGZWPFDTKFQIYCWHJVLNHIQIBTKHJVNPIST'

for shift in range(1, 26):
    for ch in decrypt(ciphertext, shift):
        print(ch, end='')
    print('\n')
