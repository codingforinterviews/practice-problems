def rotate(array, n):
    length = len(array)
    if length == n or n == 0:
        return array
    else:
        result = [0] * length
        for i in xrange(length):
            result[(i+n) % length] = array[i]
        return result
