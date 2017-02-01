fun quicksort(items: Array<Int>, left: Int, right: Int) {
    if (left < right) {
        val lastPivotPosition = partition(items, left, right)

        quicksort(items, left = left, right = lastPivotPosition - 1) // Left side
        quicksort(items, left = lastPivotPosition + 1, right = right) // Right side
    }
}

/**
 * @return last pivot position
 */
fun partition(items: Array<Int>, left: Int, right: Int): Int {
    val x = items[right]
    var i = left - 1

    for (j in left..right - 1) {
        if (items[j] <= x) {
            i++
            swap(items, i, j)
        }
    }

    i++
    swap(items, i, right)
    return i
}

fun swap(items: Array<Int>, i: Int, j: Int) {
    val itemI = items[i]
    items[i] = items[j]
    items[j] = itemI
}


fun main(args: Array<String>) {
    val array = arrayOf(5, 1, 2, 6, 9, 2, 2, 2220)

    quicksort(array, 0, array.size - 1)

    array.forEach { print(" $it") }
}