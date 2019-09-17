package easy;

public class Solution557 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] array = s.toCharArray();
        int i= 0;
        int j = s.length()-1;
        swap(i, j, array);

        int start = 0;
        int finish = 0;
        while(finish < s.length()) {
            while(finish < s.length() && array[finish] != ' ') {
                finish++;
            }
            swap(start, finish, array);
            start = finish + 1;
        }
        return new String(array);
    }

    private void swap(int i, int j, char[] array) {
        while (i< j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
}
