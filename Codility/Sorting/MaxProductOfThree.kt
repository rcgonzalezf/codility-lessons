// https://app.codility.com/demo/results/trainingJW2K8C-6X5/

import kotlin.math.*

fun solution(A: IntArray): Int {
    var mostNegativeValue = Int.MAX_VALUE
    var postMostNegativeValue = Int.MAX_VALUE
    var prePreMaxValue = Int.MIN_VALUE
    var preMaxValue = Int.MIN_VALUE
    var maxValue = Int.MIN_VALUE
  
    A.forEach {
        if (it > maxValue) {
            // shift all positive numbers
            prePreMaxValue = preMaxValue
            preMaxValue = maxValue
            maxValue = it
        } else if (it > preMaxValue) {
            prePreMaxValue = preMaxValue
            preMaxValue = it
        } else if (it > prePreMaxValue) {
            prePreMaxValue = it
        }
        if (it < mostNegativeValue) {
            postMostNegativeValue = mostNegativeValue
            mostNegativeValue = it
        } else if (it < postMostNegativeValue) {
            postMostNegativeValue = it
        }

    }

    // Multiply the 2 most negative values (positive number) and the max value
    val productUsingNegatives = mostNegativeValue * postMostNegativeValue * maxValue
    val productUsingPositives = prePreMaxValue * preMaxValue * maxValue

    return max(productUsingNegatives, productUsingPositives)
}
