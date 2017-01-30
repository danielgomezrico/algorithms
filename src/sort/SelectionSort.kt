package sort

fun selectionSort(items: List<Int>): List<Int> {
    if (items.size < 2) return items

    val orderedItems = mutableListOf<Int>()
    var possibleSmallerItem: Int = 0

    (0..items.size).forEach { i ->
        (0..items.size).forEach { j ->
            if (items[i] > items[j]) {
                possibleSmallerItem = items[j]
            }
        }

        orderedItems.add(possibleSmallerItem)
    }



    return orderedItems
}

fun main(args: Array<String>) {
    selectionSort(listOf(22, 4, 65, 1, 34, 235, 236, 4, 624325, 66, 6, 6, 22, 4, 5, 643, 3, 4)).forEach { print(" $it") }
}