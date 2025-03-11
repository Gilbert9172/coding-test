package datastructure.linear.array

import kotlin.math.max
import kotlin.math.min

fun main() {
    val intArr = intArrayOf(7, 1, 5, 3, 6, 4)
    println(maxProfit(intArr))
}

fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var minPrice = prices[0]

    for (price in prices) {
        minPrice = min(minPrice, price)
        maxProfit = max(maxProfit, price - minPrice)
    }

    return maxProfit
}
