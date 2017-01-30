package sort

fun quicksort(items: List<Int>): List<Int> {
    if (items.size < 2) {
        return items
    } else {
        val pivot = items[items.size / 2]
        val smallerItems = items.filter { it < pivot }
        val greaterItems = items.filter { it > pivot }

        return quicksort(smallerItems) + pivot + quicksort(greaterItems)
    }
}

fun main(args: Array<String>) {
    quicksort(listOf(22, 4, 65, 1, 34, 235, 236, 4, 624325, 66, 6, 6, 22, 4, 5, 643, 3, 4)).forEach { print(" $it") }
}