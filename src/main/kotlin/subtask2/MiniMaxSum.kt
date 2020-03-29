package subtask2

class MiniMaxSum {

    fun getResult(input: IntArray): IntArray {

        input.sort();

        var sumMin: Int = 0;
        var sumMax: Int = 0;

        for (i in input.indices) {
            if (i != input.lastIndex) {
                sumMin += input[i];
            }
            if (i != 0) {
                sumMax += input[i]
            }
        }
        return intArrayOf(sumMin, sumMax);
    }
}
