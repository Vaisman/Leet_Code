package easy;

public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.isEmpty() || haystack.isEmpty()) return 0;

        int pos = -1;

        for(int i =0; i< haystack.length() - needle.length(); i++) {

            // position found
            if (haystack.charAt(i) == needle.charAt(0))  {
                pos = i;

                // compare substring
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        pos = -1;
                        break;
                    }
                }
            }
            if (pos != -1) {
                break;
            }
        }
        return pos;
    }
}

//Input: haystack = "hello", needle = "ll"
//        Output: 2
