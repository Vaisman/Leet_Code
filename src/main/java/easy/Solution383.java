package easy;

public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null)
            return (ransomNote == magazine);
        int[] nums = new int[26];
        for(char c: ransomNote.toCharArray()) {
            nums[c-'a']++;
        }
        for(char c: magazine.toCharArray()) {
            if (--nums[c-'a'] < 0)
                return false;
        }
        return true;
    }
}
