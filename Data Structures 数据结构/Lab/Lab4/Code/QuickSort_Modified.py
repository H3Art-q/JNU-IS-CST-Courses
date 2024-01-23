def modQuickSort(alist, minrange):
    modQuickSortHelper(alist, 0, len(alist)-1, minrange)


def modQuickSortHelper(alist, first, last, minrange):
    if first < last:

        if last - first >= minrange:
            splitpoint = partition(alist, first, last)

            modQuickSortHelper(alist, first, splitpoint-1, minrange)
            modQuickSortHelper(alist, splitpoint+1, last, minrange)
        else:
            for index in range(first + 1, last + 1):

                currentvalue = alist[index]
                position = index

                while position > 0 and alist[position-1] > currentvalue:
                    alist[position] = alist[position-1]
                    position = position-1

                alist[position] = currentvalue


def partition(alist, first, last):
    pivotvalue = alist[first]

    leftmark = first + 1
    rightmark = last
    done = False
    while not done:

        while leftmark <= rightmark and \
                alist[leftmark] <= pivotvalue:
            leftmark = leftmark + 1

        while alist[rightmark] >= pivotvalue and \
                rightmark >= leftmark:
            rightmark = rightmark - 1

        if rightmark < leftmark:
            done = True
        else:
            temp = alist[leftmark]
            alist[leftmark] = alist[rightmark]
            alist[rightmark] = temp

    temp = alist[first]
    alist[first] = alist[rightmark]
    alist[rightmark] = temp

    return rightmark
