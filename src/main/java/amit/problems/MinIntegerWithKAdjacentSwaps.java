package amit.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a string num representing the digits of a very large integer and an integer k.
 * <p>
 * You are allowed to swap any two adjacent digits of the integer at most k times.
 * <p>
 * Return the minimum integer you can obtain also as a string.
 * <p>
 * https://leetcode.com/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/
 * <p>
 * Category: Hard
 * Status not working
 */
public class MinIntegerWithKAdjacentSwaps {

    public static void main(String[] args) {
        MinIntegerWithKAdjacentSwaps minIntegerWithKAdjacentSwaps = new MinIntegerWithKAdjacentSwaps();
//        System.out.println(minIntegerWithKAdjacentSwaps.minInteger("4321", 4));//1342
//        System.out.println(minIntegerWithKAdjacentSwaps.minInteger("100", 1));//010
//        System.out.println(minIntegerWithKAdjacentSwaps.minInteger("36789", 1000));//36789
//        System.out.println(minIntegerWithKAdjacentSwaps.minInteger("22", 22));//22
//        System.out.println(minIntegerWithKAdjacentSwaps.minInteger("9438957234785635408", 23));//0345989723478563548
        System.out.println(minIntegerWithKAdjacentSwaps.minInteger("294984148179", 11));//124498948179 [Fails due to remaining k not able to swap 8 and 9]
    }

    //Started with greedy approach
    public String minInteger(String num, int k) {
        char[] nos = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        int currPlace = 0;
        StringBuilder sb = new StringBuilder(num);
        Map<Character, List<Integer>> locs = getChars(sb, currPlace);
        for (int i = 0; i < nos.length && k > 0; i++) {
            List<Integer> pos = locs.get(nos[i]);//Find a list positions for a character
            if (!pos.isEmpty()) {
                for (int idx : pos) {
                    if (idx - currPlace < k) { //if position can be replacement directly with currPlace then go ahead and replace it.
                        if (idx != currPlace) { //if current char was already in currPlace then don't count swap but just increment currPlaces byt one;
                            sb.insert(currPlace, nos[i]);
                            sb.deleteCharAt(idx + 1);
                            k -= idx - currPlace;
                        }
                        currPlace++;
                    } else {
                        break;
                    }
                }
            }
        }

        return sb.toString();
    }

    public Map<Character, List<Integer>> getChars(StringBuilder str, int start) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = start; i < str.length(); i++) {
            map.computeIfAbsent(str.charAt(i), kl -> new LinkedList<>()).add(i);
        }
        return map;
    }
}
