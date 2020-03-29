package subtask3

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        var b_actual = 0;

        for (i in bill.indices) {
            if (i == k) {
                continue
            }
            b_actual += bill[i];
        }
        if (b_actual/2 == b){
            return "Bon Appetit"
        }else{
            return "" +  (b-(b_actual/2));
        }
    }
}
