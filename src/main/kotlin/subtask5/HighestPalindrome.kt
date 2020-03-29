package subtask5

import java.lang.StringBuilder

class HighestPalindrome {
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        val numberList = digitString.toMutableList()
        var changeLimit = k;
        var rightEdge: Int;
        var leftEdge: Int;

        if (n % 2 != 0) {
            leftEdge = n / 2 - 1;
            rightEdge = n / 2 + 1;
        } else {
            leftEdge = n / 2 - 1
            rightEdge = n / 2
        }
        while (leftEdge >= 0) {
            if (numberList[leftEdge].toInt() != numberList[rightEdge].toInt()) {
                val max = maxOf(numberList[leftEdge].toInt(), numberList[rightEdge].toInt())
                numberList[leftEdge] = max.toChar();
                numberList[rightEdge] = max.toChar();
                changeLimit--;
            }
            leftEdge--
            rightEdge++
        }
        if (changeLimit > 0) {
            numberList[0] = '9'
            numberList[numberList.size - 1] = '9'
            changeLimit--
        }
        if (changeLimit < 0) {
            return "-1"
        }
        val builder = StringBuilder()
        for (string in numberList) {
            builder.append(string)
        }
        return builder.toString();
    }
}
