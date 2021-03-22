package amit.problems.arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * Implement the class ProductOfNumbers that supports two methods:
 *
 * 1. add(int num)
 *
 *     Adds the number num to the back of the current list of numbers.
 *
 * 2. getProduct(int k)
 *
 *     Returns the product of the last k numbers in the current list.
 *     You can assume that always the current list has at least k numbers.
 *
 * At any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.
 *
 * https://leetcode.com/problems/product-of-the-last-k-numbers
 *
 * Status: Working
 */
public class ProductOfNumbers {

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        System.out.println(productOfNumbers.getProduct(2)); // return 20. The product of the last 2 numbers is 5 * 4 = 20
        System.out.println(productOfNumbers.getProduct(3)); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
        System.out.println(productOfNumbers.getProduct(4)); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        System.out.println(productOfNumbers.getProduct(2)); // return 32. The product of the last 2 numbers is 4 * 8 = 32
    }

    private final List<Integer> nums = new LinkedList<>();
    private final Map<Integer, Integer> products = new HashMap<>();
    private final LinkedList<Integer> zeroes = new LinkedList<>();

    public void add(int num) {
        int oldProduct = products.getOrDefault(nums.size(), 1);
        nums.add(num);
        if(num == 0) {
            zeroes.add(nums.size());
            products.put(nums.size(), 1);
        } else {
            products.put(nums.size(), oldProduct * num);
        }
    }

    public int getProduct(int k) {
        if(zeroes.peekLast() != null && zeroes.peekLast() > nums.size() - k) {
            return 0;
        }
        return products.get(nums.size()) / products.getOrDefault(nums.size() - k, 1);
    }

}
