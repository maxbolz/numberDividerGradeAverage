import java.util.Arrays;

/***
 A positive integer is called a number divider if every decimal digit of
 the number is a divisor of the number.  That is, if the number is evenly
 divisible by each one of its digits.  For example, 128 is a number divider
 because it is evenly divisible by 1, 2 and 8.  However, 26 is not a number
 divider because if is not evenly divisible by 6.  Note that 0 is not
 considered to be a divisor of any number, so any number containing a 0
 digit is NOT a number divider.
 ***/
public class NumberDivider {
    /**
     * @param number the number to be tested
     *               Precondition: number >0
     * @return true if every decimal digit of number divides evenly
     * into the number, false otherwise
     */
    public static boolean isNumberDivider(int number) {

        int temp = number;

        while (temp > 0) {

            if (temp%10 == 0 || number%(temp%10) != 0) {return false;}

            temp /=10;

        }
        return true;
    }

    /**
     * @param start starting point for values to be checker
     *              Precondition: start >0
     * @param x   the size of the array to be returned
     *              Precondition: num > 0
     * @return an array containing the first num integers >= start
     * that are number dividers
     **/
    public static int[] firstXNumberDividers(int start, int x) {

        int[] a = new int[x];
        int i = 0;

        while (i < x) {

            if (isNumberDivider(start))
            {
                a[i] = start;
                i++;
            }
            start++;
        }
        return a;
    }

    public static void main(String[] args) {

        int a = 128, b = 124, c = 26, d = 101, e = 52, f = 24;

        System.out.println("");
        System.out.println("Is " + a + " a Number Divider?: " + isNumberDivider(a));
        System.out.println("Is " + b + " a Number Divider?: " + isNumberDivider(b));
        System.out.println("Is " + c + " a Number Divider?: " + isNumberDivider(c));
        System.out.println("Is " + d + " a Number Divider?: " + isNumberDivider(d));
        System.out.println("Is " + e + " a Number Divider?: " + isNumberDivider(e));
        System.out.println("Is " + f + " a Number Divider?: " + isNumberDivider(f));

        System.out.println("");
        int[] divArr = firstXNumberDividers(128, 4);
        System.out.println("First 4 NDs from 128: " + Arrays.toString(divArr));

        int[] divArr2 = firstXNumberDividers(81, 6);
        System.out.println("First 6 NDs from 81: " + Arrays.toString(divArr2));

        int[] divArr3 = firstXNumberDividers(300, 8);
        System.out.println("First 8 NDs from 300: " + Arrays.toString(divArr3));

        int[] divArr4 = firstXNumberDividers(10, 20);
        System.out.println("First 20 NDs from 10: " + Arrays.toString(divArr4));
    }
}