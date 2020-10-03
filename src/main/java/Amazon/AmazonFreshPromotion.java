package Amazon;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AmazonFreshPromotion {
    public static int winPrize1(String[][] codeList, String[] shoppingCart) {
        // checking corner cases
        if (shoppingCart == null || shoppingCart.length == 0) {
            return 0;
        }

        if (codeList == null || codeList.length == 0) {
            return 1;
        }

        int i = 0;
        int j = 0;
        while (i < codeList.length && j + codeList[i].length <= shoppingCart.length) {
            boolean match = true;
            for (int k = 0; k < codeList[i].length; k++) {
                if (!codeList[i][k].equals("anything") && !shoppingCart[j + k].equals(codeList[i][k])) {
                    match = false;
                    break;
                }
            }

            if (match) {
                j += codeList[i].length;
                i++;
            } else {
                j++;
            }
        }

        return (i == codeList.length) ? 1 : 0;
    }

    private static int winPrize(String[][] codeList,String[] shoppingCart) {
        if (codeList == null || codeList.length == 0)
            return 1;
        if (shoppingCart == null || shoppingCart.length == 0)
            return 0;

        int i = 0;
        int j = 0;
        for (int k = 0; k < shoppingCart.length; k++) {
            //when match success
            if (codeList[i][j].equals(shoppingCart[k]) || codeList[i][j].equals("anything")) {
                j++;
                if (j == codeList[i].length) {
                    i++;
                    j = 0;
                }
                if (i == codeList.length)
                    return 1;
            } else {
                //when match failed, k and j both go back.
                k -= j;
                j = 0;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList2 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
        String[][] codeList3 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
        String[][] codeList4 = { { "apple", "apple" }, { "apple", "apple", "banana" } };
        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
        String[][] codeList5 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList6 = { { "apple", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList7= { { "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList8 = {{"apple", "orange"}, {"orange", "banana", "orange"}};
        String[] shoppingCart8 = {"apple", "orange", "banana", "orange", "orange", "banana", "orange", "grape"};
        String[][] codeList9= { { "anything", "anything", "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart9 = {"orange", "apple", "banana", "orange", "apple", "orange", "orange", "banana", "apple", "banana"};

        assertEquals(winPrize(codeList1, shoppingCart1), 1);
        assertEquals(winPrize(codeList2, shoppingCart2), 0);
        assertEquals(winPrize(codeList3, shoppingCart3), 0);
        assertEquals(winPrize(codeList4, shoppingCart4), 0);
        assertEquals(winPrize(codeList5, shoppingCart5), 1);
        assertEquals(winPrize(codeList6, shoppingCart6), 1);
        assertEquals(winPrize(codeList7, shoppingCart7), 1);
        assertEquals(winPrize(codeList8, shoppingCart8), 1);
        assertEquals(winPrize(codeList9, shoppingCart9), 1);
    }
}
