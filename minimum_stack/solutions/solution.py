"""
Minimum Stack Python Solution

"""


class MinimumStack(object):
    def __init__(self):
        """
        Use two empty lists to hold our data and minimums

        :return:
        """
        self.__data = list()
        self.__minimum = list()

    def push(self, val):
        """
        Typical stack push, but we also want to do logic on minimum values

        :param val:
        :return:
        """
        if len(self.__minimum) > 0:
            if val < self.__minimum[-1]:
                self.__minimum.append(val)
            else:
                self.__minimum.append(self.__minimum[-1])
        else:
            self.__minimum.append(val)
        self.__data.append(val)

    def pop(self):
        """
        Lists have a pop feature already, but we also need to clean up
        the minimum list to have our data aligned

        :return:
        """
        if len(self.__data) < 1:
            raise IndexError
        self.__minimum.pop()
        return self.__data.pop()

    def get_minimum(self):
        """
        Get the last pushed value on the minimum list

        :return:
        """
        if len(self.__data) < 1:
            raise IndexError
        return self.__minimum[-1]


if '__main__' == __name__:
    stack = MinimumStack()
    for n in [1, 2, 3, 5, 0]:
        stack.push(n)

    print(stack.get_minimum())
