package easy;

public class Solution1103 {
    public int[] distributeCandies(int candies, int numPeople) {
        if (candies <= 0 || numPeople <= 0) {
            return new int[] {};
        }

        int[] people = new int[numPeople];
        for (int give = 0; candies > 0; candies -= give) {
            people[give % numPeople] +=  Math.min(candies, ++give);
        }
        return people;
    }
}
