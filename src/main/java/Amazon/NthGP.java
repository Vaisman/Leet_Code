package Amazon;

public class NthGP {
    //to convert into array of characters, you can use the toString() and toCharArray() functions on Double
    //Note: Do not use the above on double as it is the primitive data type and has no associated functions.
    public static char[] nthTerm(double input1, double input2, int input3) {
        Double r = input2 / input1;
        Double a = input1 / r;
        Double ans = a * Math.pow(r, input3 - 1);
        return ans.toString().toCharArray();
    }

    //If toString() and toCharArray() functions do not work use function:
    public static char[] dtoch(Double num) {
        String str = num + "";
        char[] arr = new char[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i);
        }
        return arr;
    }

    public static void main(String []args){
        System.out.print(nthTerm(1.0,2.0,4));
    }
}
