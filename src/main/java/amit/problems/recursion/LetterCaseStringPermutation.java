package amit.problems.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, find all of its permutations preserving the character sequence but changing case.
 */
public class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        findPermutations(str, 0, "", permutations);
        return permutations;
    }

    public static void findPermutations(String str, int idx, String result, List<String> permutations) {
        if (result.length() == str.length()) {
            permutations.add(result);
            return;
        }
        char car = str.charAt(idx);
        findPermutations(str, idx + 1, result + car, permutations);//Original case
        if (Character.isLetter(car)) {//Opposite case.
            if (Character.isUpperCase(car)) {//isUppercase
                findPermutations(str, idx + 1, result + Character.toLowerCase(car), permutations);
            } else {
                findPermutations(str, idx + 1, result + Character.toUpperCase(car), permutations);
            }
        }
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }

}