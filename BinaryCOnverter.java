import java.util.Scanner;

/** class containing the methods that run the BinaryConverter program.
 *
 */
public class BinaryCOnverter {

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

    /** runs the binary converter program.
     *
     */
    public static void run() {
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Welcome to the BinaryConverter");
        System.out.println("To begin specify if you are:");

        int check = 0;
        while (check == 0) {
            System.out.println("1. Converting a number to binary string");
            System.out.println("2. Converting a Binary String to a number!" + '\n'
                + "3. EXIT" + '\n'
                +  "Enter the corresponding number to select a function!");

            String num = input.nextLine();  // Read user input
            if (num.equals("1")) {
                System.out.println("Enter a whole number to be converted to a binary string: ");
                String number = input.nextLine();  // Read user input
                try {
                    String bin = toBinary(Integer.parseInt(number));
                    System.out.println(bin + '\n');
                }

                catch (Exception e) {
                    System.out.println("Invalid Response! Please try again.");
                }

            }
            else if (num.equals("2")) {
                System.out.println("Enter a binary string to be converted to a whole number: ");
                String binStr = input.nextLine();  // Read user input
                try {
                    int number = toDecimal(binStr);
                    System.out.println(number + '\n');
                }

                catch (Exception e) {
                    System.out.println("Invalid Response! Please try again.");
                }
            }

            else if (num.equals("3")) {
                check = 1;
            }
            else {
                System.out.println("Invalid Response! Please try again.");
            }
        }

    }

    public static void main(String[] args) {
        run();


    }

}


