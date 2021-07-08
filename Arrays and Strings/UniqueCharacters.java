import java.util.Arrays;
import java.util.HashSet;

public class UniqueCharacters {

    public static void main(String[] args) {

        System.out.println(isContainingUniqueCharacterUsingHashSet("draw"));
        System.out.println(isContainingUniqueCharacterUsingForLoops("draw"));
        System.out.println(isContainingUniqueCharacterUsingSorting("draw"));
    }

    /*
    O(n) - time complexity - where n : length of the string and time will be for iterating the string
    O(1) - space complexity - as number of characters in any encoding system will be limited
    */
    public static boolean isContainingUniqueCharacterUsingHashSet(String str) {
        HashSet<Character> hashSet = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            if (hashSet.contains(str.charAt(i))) {
                return false;
            }
            hashSet.add(str.charAt(i));
        }
        return true;
    }

    /*
    O(n^2) - time complexity  - where n : length of the string and time will be for iterating the string twice in a loop
    O(1) - space complexity
    */
    public static boolean isContainingUniqueCharacterUsingForLoops(String str) {

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
    /*
       O(nlogn) - time complexity  - where n : length of the string and time taken for sorting will be O(nlogn)
       O(1) - space complexity
       */
    public static boolean isContainingUniqueCharacterUsingSorting(String str) {

        char sortedString[] = str.toCharArray();

        // sorted string
        Arrays.sort(sortedString);

        for (int i = 1; i < sortedString.length; i++) {
            if (sortedString[i] == sortedString[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
