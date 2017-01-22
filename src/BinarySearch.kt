fun binarySearch(items: List<Int>, item: Int): Int {
    var low = 0
    var high = items.size - 1
    var mid: Int

    while (low <= high) {
        mid = (low + high) / 2
        val guess = items[mid]

        if (guess == item) {
            return mid
        } else if (guess > item) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }

    return -1
}

fun main(args: Array<String>) {
    println(binarySearch((0..128).toList(), 7))
}