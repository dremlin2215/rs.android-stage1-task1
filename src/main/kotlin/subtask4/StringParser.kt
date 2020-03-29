package subtask4

class StringParser {

    private val fMap: MutableMap<Int, String> =
        emptyMap<Int, String>().toMutableMap();

    private val list1: MutableList<Pair> = emptyList<Pair>().toMutableList()
    private val list2: MutableList<Pair> = emptyList<Pair>().toMutableList()
    private val list3: MutableList<Pair> = emptyList<Pair>().toMutableList()

    private val delimiter11: Char = '<'
    private val delimiter12: Char = '>'
    private val delimiter21: Char = '['
    private val delimiter22: Char = ']'
    private val delimiter31: Char = '('
    private val delimiter32: Char = ')'

    fun getResult(inputString: String): Array<String> {

        val array = inputString.toCharArray()

        for (index in array.indices) {
            when (array[index]) {
                delimiter11, delimiter12 -> list1.add(Pair(index, array[index]))
                delimiter21, delimiter22 -> list2.add(Pair(index, array[index]))
                delimiter31, delimiter32 -> list3.add(Pair(index, array[index]))
            }

        }
        generateStrings(inputString)
        val returnArray: Array<String> = Array(fMap.size) { "" }
        var counter = 0;
        for (i in 0 .. inputString.length){
            if (fMap.containsKey( i )){
                returnArray[counter] = fMap.getValue(i);
                counter++;
            }
        }
        return returnArray;
    }

    private fun generateStrings(inputString: String) {
        for (j in 0..inputString.length) {
            for (i in 0..list1.size - 2) {
                if (list1[i].value == delimiter11 && list1[i + 1].value == delimiter12) {
                    fMap[list1[i].index] = inputString.substring(list1[i].index + 1, list1[i + 1].index)
                    list1.removeAt(i + 1)
                    list1.removeAt(i)
                    break
                }
            }
            for (i in 0..list2.size - 2) {
                if (list2[i].value == delimiter21 && list2[i + 1].value == delimiter22) {
                    fMap[list2[i].index] = inputString.substring(list2[i].index + 1, list2[i + 1].index)
                    list2.removeAt(i + 1)
                    list2.removeAt(i)
                    break
                }
            }
            for (i in 0..list3.size - 2) {
                if (list3[i].value == delimiter31 && list3[i + 1].value == delimiter32) {
                    fMap[list3[i].index] = inputString.substring(list3[i].index + 1, list3[i + 1].index)
                    list3.removeAt(i + 1)
                    list3.removeAt(i)
                    break
                }
            }
        }
    }
}

class Pair(val index: Int, val value: Char) {
    override fun toString(): String {
        return "Pair(index=$index, value=$value)"
    }
}