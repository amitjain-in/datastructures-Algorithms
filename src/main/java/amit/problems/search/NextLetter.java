package amit.problems.search;

/**
 * Given an array of lowercase letters sorted in ascending order, find the smallest letter in the given array greater than a given ‘key’.
 * <p>
 * Assume the given array is a circular list, which means that the last letter is assumed to be connected with the first letter.
 * This also means that the smallest letter in the given array is greater than the last letter of the array and is also the first letter of the array.
 * <p>
 * Write a function to return the next letter of the given ‘key’
 */
public class NextLetter {
    public static char searchNextLetter(char[] letters, char key) {
        if (key < letters[0] || key > letters[letters.length - 1]) // if the 'key' is bigger than the biggest or smaller than smallest element
            return letters[0]; //Because this is circular array

        int start = 0, end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // since the loop is running until 'start <= end', so at the end of the while loop, 'start == end+1'
        // we are not able to find the element in the given array, so the next big number will be arr[start]
        return letters[start % letters.length];
    }

    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'f'));//h
        System.out.println(NextLetter.searchNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'b'));//c
        System.out.println(NextLetter.searchNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'm'));//a
        System.out.println(NextLetter.searchNextLetter(new char[]{'a', 'c', 'f', 'h'}, 'h'));//a
    }
}
