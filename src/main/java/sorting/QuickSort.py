def quick_sort(arr):
    s = [[], [], []]
    pivot = arr[0]  # Pivot

    [s[(el < pivot) + (el > pivot) * 2].append(el) for el in arr]
    return s[1] + s[0] + s[2]


if __name__ == "__main__":
    print(quick_sort([5, 1, 3, 7, 8]))
