import java.util.Arrays;

public class CheckPermutations {

    public static void main(String[] args) {

        System.out.println(arePermutationsUsingHashSet("abc", "bac"));
        System.out.println(arePermutationsUsingSorting("abc", "bac"));
        System.out.println(arePermutationsUsingSorting("abc", "bbc"));
    }

    public static boolean arePermutationsUsingSorting(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }
        char[] firstSorted = first.toCharArray();
        Arrays.sort(firstSorted);

        char[] secondSorted = second.toCharArray();
        Arrays.sort(secondSorted);

        for (int firstPtr = 0, secondPtr = 0; firstPtr < first.length(); firstPtr++, secondPtr++) {
            if (firstSorted[firstPtr++] != secondSorted[secondPtr++]) {
                return false;
            }
        }
        return true;
    }

    public static boolean arePermutationsUsingHashSet(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }
        int[] firstFrequency = getFrequency(first);
        int[] secondFrequency = getFrequency(second);

        for (int i = 0; i < 26; i++) {
            if (firstFrequency[i] != secondFrequency[i]) {
                return false;
            }
        }

        return true;
    }

    public static int[] getFrequency(String str) {
        int[] frequency = new int[26];

        for (int i = 0; i < str.length(); i++) {
            frequency[str.charAt(i) - 'a']++;
        }
        return frequency;
    }
}
