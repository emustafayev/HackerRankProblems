# //    1 2 3 4 5
# //    4
# //    5 1 2 3 4


def rotateLeft(d, arr):
    return arr[d:] + arr[:d]


if __name__ == "__main__":
    print(rotateLeft(4, [1, 2, 3, 4, 5]))
