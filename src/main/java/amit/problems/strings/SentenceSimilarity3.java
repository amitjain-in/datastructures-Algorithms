package amit.problems.strings;

public class SentenceSimilarity3 {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if (s1.length > s2.length) {
            return compare(s1, s2);
        }
        return compare(s2, s1);
    }

    //Try to compare the smaller with larger from both sides. If all the words from smaller exists in the larger string in same sequence then
    //Final condition will come as true and false otherwise.
    private boolean compare(String[] larger, String[] smaller) {
        int endMatches = 0;
        for (int back = smaller.length - 1; back >= 0; back--) {
            if (!larger[larger.length - smaller.length + back].equals(smaller[back])) {
                break;
            }
            endMatches++;
        }

        int beginMatches = 0;
        for (int front = 0; front < smaller.length - endMatches; front++) {//Since we already match 'endMatches characters from back exclude that while matching from front.
            if (!larger[front].equals(smaller[front])) {
                break;
            }
            beginMatches++;
        }

        return endMatches + beginMatches == smaller.length;//All the variables of smaller string now exists in large in same sequence
    }

    public static void main(String[] args) {
        SentenceSimilarity3 sentenceSimilarity3 = new SentenceSimilarity3();
        System.out.println(sentenceSimilarity3.areSentencesSimilar("My name is Haley", "My Haley"));
        System.out.println(sentenceSimilarity3.areSentencesSimilar("My Haley", "My name is Haley"));
        System.out.println(sentenceSimilarity3.areSentencesSimilar("My Haley", "My Haley is"));
        System.out.println(sentenceSimilarity3.areSentencesSimilar("is My Haley", "My Haley"));
        System.out.println(sentenceSimilarity3.areSentencesSimilar("of", "My Haley"));
        System.out.println(sentenceSimilarity3.areSentencesSimilar("Ogn WtWj HneS", "Ogn WtWj HneS"));
    }
}
