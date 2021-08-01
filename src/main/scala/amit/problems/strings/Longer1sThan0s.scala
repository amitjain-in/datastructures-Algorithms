package amit.problems.strings

/**
 *
 * Given a binary string s, return true if the longest contiguous segment of 1s is strictly longer than the longest contiguous segment of 0s in s. Return false otherwise.
 * For example, in s = "110100010" the longest contiguous segment of 1s has length 2, and the longest contiguous segment of 0s has length 3.
 * Note that if there are no 0s, then the longest contiguous segment of 0s is considered to have length 0. The same applies if there are no 1s.
 *
 * https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/
 * Level: Easy
 */
object Longer1sThan0s {
    def main(args: Array[String]): Unit = {
        val lo = new Longer1sThan0s()
        println(lo.checkZeroOnes("1101")) //true because '11'{2} > '0'{1}
        println(lo.checkZeroOnes("111000")) //false because '111'{3} == '000'{3}
    }
}

class Longer1sThan0s {
    //Works
    def checkZeroOnes(s: String): Boolean = {
        var max1s = 0
        var max0s = 0
        var prev: Char = ' '
        var curr1s = 0
        var curr0s = 0
        for (i <- 0 until s.length) {
            val c = s.charAt(i);
            if (c == '1') {
                if (prev == '0') curr0s = 0
                curr1s += 1
                max1s = Math.max(max1s, curr1s)
            } else {
                if (prev == '1') curr1s = 0
                curr0s += 1
                max0s = Math.max(max0s, curr0s)
            }
            prev = c
        }
        max1s > max0s
    }
}
