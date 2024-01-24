class Dragon:
    '''
    The key to solving this problem is:

    A curve of order n is a curve of order n-1
    followed by an L then followed by a curve
    of order n-1 traversed in reverse order
    '''

    def __init__(self, num) -> None:
        self.times = num
        self.sequence = 'F'

    def getSequence(self) -> str:
        return self.sequence

    # Recursively generate the sequence
    def sequenceGenerator(self) -> str:
        if self.times > 1:
            self.times -= 1
            self.sequence = self.sequence + 'L' + self.swapDirection()
            return self.sequenceGenerator()

    def swapDirection(self) -> str:
        tempSequence = self.sequence[::-1]  # Reverse the sequence
        newSequence = ''

        for direction in tempSequence:
            if direction == 'L':
                newSequence = newSequence + 'R'
            elif direction == 'R':
                newSequence = newSequence + 'L'
            else:
                newSequence = newSequence + 'F'

        return newSequence
