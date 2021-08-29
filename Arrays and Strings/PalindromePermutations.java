import java.util.ArrayList;
import java.util.List;

public class PalindromePermutations {
    public static void main(String[] args) {

        System.out.println(isPalindromePermutationUsingHashMap("carreraec"));
        System.out.println(isPalindromePermutationUsingAllPermutations("aabbv"));
        System.out.println(isPalindromePermutationUsingBitVector("aadrara"));
    }

    /*
     * using permutation
     * */
    public static boolean isPalindromePermutationUsingAllPermutations(String str) {

        List<String> permutations = new ArrayList<>();
        getAllPermutation(permutations, str.toCharArray(), 0, str.length() - 1);
        for (String perm : permutations) {
            if (isPalindrome(perm)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPalindrome(String str) {

        for (int first = 0, second = str.length() - 1; first <= second; first++, second--) {
            if (str.charAt(first) != str.charAt(second)) {
                return false;
            }
        }
        return true;
    }

    public static void getAllPermutation(List<String> permutations, char[] arr, int start, int end) {
        if (start == end) {
            permutations.add(new String(arr));
        }
        for (int i = start; i <= end; i++) {
            swap(start, i, arr);
            getAllPermutation(permutations, arr, start + 1, end);
            swap(start, i, arr);
        }
    }

    public static void swap(int first, int second, char[] arr) {
        char temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    // Using hashmap
    public static boolean isPalindromePermutationUsingHashMap(String str) {

        int hash[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            hash[str.charAt(i) - 'a']++;
        }
        boolean numberOfOddsMoreThanOne = false;

        for (int i = 0; i < 26; i++) {
            if (hash[i] % 2 == 1) {
                if (numberOfOddsMoreThanOne) {
                    return false;
                }
                numberOfOddsMoreThanOne = true;
            }
        }
        return true;
    }

    // using bitvector
    public static boolean isPalindromePermutationUsingBitVector(String str) {
        int bitVector = 0;

        for (int i = 0; i < str.length(); i++) {
            int mask = 1 << (str.charAt(i) - 'a');
            bitVector = bitVector ^ mask;
        }

        if (isMoreThanOneBitSet(bitVector)) {
            return false;
        }

        return true;
    }

    public static boolean isMoreThanOneBitSet(int bitVector) {
        boolean isOneBitSet = false;
        for (int i = 0; i <= 25; i++) {
            int mask = 1 << i;
            if ((mask & bitVector) > 0) {
                if (isOneBitSet) {
                    return true;
                }
                isOneBitSet = true;
            }
        }
        return false;
    }

}
