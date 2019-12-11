package medium;

public class Solution364 {

    /*
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int unweighted = 0;
        int weighted = 0;

        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger())
                    unweighted += ni.getInteger();
                else
                    nextLevel.addAll(ni.getList());
            }
            weighted += unweighted;
            nestedList = nextLevel;
        }
        return weighted;
    }
    */
}
