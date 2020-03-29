package subtask1

class HappyArray {

    private var happyList: MutableList<Int> = emptyList<Int>().toMutableList()
    /**
     * Number or runs through list can be optimized via flag.
     */
    fun convertToHappy(sadArray: IntArray): IntArray {
        if (sadArray.size <= 2) {
            return sadArray
        }
        for (i in sadArray.indices) {
            happyList.add(sadArray[i])
        }
        for (i in 0..sadArray.size - 2) {
            deleteOneElement()
        }
        return happyList.toIntArray();
    }

    private fun deleteOneElement() {
        for (i in 1 until happyList.size - 1) {
            val previous = happyList[i-1]
            val current = happyList[i]
            val next = happyList[i + 1]
            if (current > next + previous) {
                happyList.removeAt(i)
                break
            }
        }
    }
}
