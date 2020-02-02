package amit.problems.recursion;

import java.util.*;

/**
 * Given a set find all of it's subsets.
 * This is simple combinatorial problem.
 */
public class AllSubsetsOfASet {

    public static void main(String[] args) {
        List<Set<String>> test = findAllSubsetsOfSet(new HashSet<>(Arrays.asList("A", "B", "C")));
        for (Set<String> testResult : test) {
            System.out.println(testResult);
        }
    }

    /**
     * First find all single element sets then add each iterated element onto that and so on.
     * This is solved recursively.
     * @param mainSet - The set for which you want to all Subsets
     * @param <T> Just typed for fancy
     * @return The list of subsets for this mainSet
     */
    private static <T> List<Set<T>> findAllSubsetsOfSet(Set<T> mainSet) {
        List<Set<T>> allSubSets = new LinkedList<>();
        if (!mainSet.isEmpty()) {
            T elem = mainSet.stream().findAny().get();
            allSubSets.add(new HashSet<>(Collections.singletonList(elem)));//This element itself is a subset
            Set<T> oneLessSet = new HashSet<>(mainSet);
            oneLessSet.remove(elem);
            List<Set<T>> subsets = findAllSubsetsOfSet(oneLessSet); //Now find all subsets that do not contain elem
            for(Set<T> subset: subsets) {
                allSubSets.add(subset);//The subsets we found from the oneLessSet are to be included
                Set<T> withElemSubset = new HashSet<>(subset);
                withElemSubset.add(elem);//Now add the elem to subset and it to our total list
                allSubSets.add(withElemSubset);
            }
        }
        return allSubSets;
    }
}
