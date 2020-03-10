package amit.problems.strings;

import java.util.*;

public class WordsPermutation {

    public static void main(String[] args) {
//        List<List<String>> permutations = new WordsPermutation().permute(new LinkedList<>(Arrays.asList("Hello", "World", "Bun", "Maska")));
        List<String> originalList = Arrays.asList("A", "B", "C", "D");
        List<String> words = new LinkedList<>(originalList);
        List<List<String>> permutations = new WordsPermutation().permute(words);
        for (List<String> permutation : permutations) {
            for (String word : permutation) {
                System.out.print(word + ",");
            }
            System.out.println();
        }
        System.out.println("Total: " + originalList.size() + " words and permutations: " + permutations.size());
    }

    public List<List<String>> permute(List<String> words) {
        String first = words.remove(0);
        List<List<String>> permutations = new LinkedList<>();
        if (words.size() > 0) {
            List<List<String>> subPermutations = permute(words);
            for (List<String> subPermutation : subPermutations) {
                for (int i = 0; i <= subPermutation.size(); i++) {
                    List<String> newSubPermutation = new ArrayList<>(subPermutation);
                    newSubPermutation.add(i, first);
                    permutations.add(newSubPermutation);
                }
            }
        } else {
            permutations.add(new LinkedList<>(Collections.singletonList(first)));
        }
        return permutations;
    }
}
