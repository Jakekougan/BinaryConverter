public class BinaryConverter {

    /**
     * converts a given number as an int to a string representation of its value in binary.
     *
     * @param num a number as an int to convert to binary
     * @return the given number as a binary string
     */
    public static String toBinary(int num) {
        int curr = num;
        String binStr = "";
        while (curr > 0) {
            int modulo = curr % 2;
            String binChar = String.valueOf(modulo);
            binStr = binStr + binChar;
            curr = curr / 2;

        }
        return reverseString(binStr);
    }

     /**
     * converts a binary string into a int.
     *
     * @param binNum a binary string to convert
     * @return the value of the binary string as a number
     */
    public static int toDecimal(String binNum) {
        char[] chars = binNum.toCharArray();
        double finalNumber = 0.0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                finalNumber = finalNumber + Math.pow(2, i);

            }

        }
        return (int) finalNumber;
    }

    /** helper function, takes a string and reverses its characters.
     *
     * @param str the string to reverse
     * @return the given string with all its chars in reverse order
     */

    public static String reverseString(String str) {
        char[] chars = str.toCharArray();
        int endIndex = chars.length - 1;
        String revString = "";
        for (int i = 0; i < endIndex; i++) {
            char temp = chars[i];
            chars[i] = chars[endIndex];
            chars[endIndex] = temp;
            endIndex = endIndex - 1;


        }

        for (int i = 0; i < chars.length; i++) {
            revString = revString + chars[i];
        }
        return revString;
    }

    public static void main(String[] args) {
        System.out.println("Hello world");
        System.out.println(toBinary(13));
        System.out.println(toDecimal("1011"));
    }

}


