package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCheck {
    // prompt
    /*
     * Create a function that takes a number as an argument and returns true if the
     * number is a valid credit card number, false otherwise.
     * 
     * Credit card numbers must be between 14-19 digits in length, and pass the Luhn
     * test, described below:
     * 
     * Remove the last digit (this is the "check digit"). Reverse the number. Double
     * the value of each digit in odd-numbered positions. If the doubled value has
     * more than 1 digit, add the digits together (e.g. 8 x 2 = 16 ➞ 1 + 6 = 7). Add
     * all digits. Subtract the last digit of the sum (from step 4) from 10. The
     * result should be equal to the check digit from step 1. Examples
     * validateCard(1234567890123456) --> false
     * 
     * // Step 1: check digit = 6, num = 123456789012345 // Step 2: num reversed =
     * 543210987654321 // Step 3: digit array after selective doubling: [1, 4, 6, 2,
     * 2, 0, 9, 8, 5, 6, 1, 4, 6, 2, 2] // Step 4: sum = 58 // Step 5: 10 - 8 = 2
     * (not equal to 6) --> false
     * 
     * validateCard(1234567890123452) --> true
     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        Long creditNumber = 0l;
        CreditCheck creditCheck = new CreditCheck();
        do {
            System.out.println("Please enter your 14-19 digit credit card number...");

            try {
                creditNumber = Long.parseLong(scan.nextLine());

                if (creditNumber.toString().length() >= 14 && creditNumber.toString().length() <= 19) {
                    System.out.println("Credit card number entered, verifying...");
                    flag = false;
                } else {
                    System.out.println("Invalid input! Please enter a 14-19 digit credit card number");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a 14-19 digit credit card number");
            }

        } while (flag != false);
        System.out.println(creditCheck.validateCard(creditNumber));

    }

    public boolean validateCard(Long creditNumber) {
        StringBuilder creditCard = new StringBuilder();
        Integer checkDigit = 0;

        creditCard.append(creditNumber);
        checkDigit = Character.getNumericValue(creditCard.charAt(creditCard.length() - 1));
        creditCard.deleteCharAt(creditCard.length() - 1);

        creditCard.reverse();
        Integer doubleOdd = 0;
        Integer[] numberArray = new Integer[creditCard.length()];
        Integer sum = 0;

        for (int i = 0; i < creditCard.length(); i++) {
            numberArray[i] = Character.getNumericValue(creditCard.charAt(i));
        }

        for (int i = 0; i < numberArray.length; i++) {
            if (numberArray[i] % 2 == 1) {
                doubleOdd = numberArray[i] * 2;
                if (doubleOdd >= 10) {
                    doubleOdd = Character.getNumericValue(doubleOdd.toString().charAt(0))
                            + Character.getNumericValue(doubleOdd.toString().charAt(1));
                }
                numberArray[i] = doubleOdd;
            }

            sum += numberArray[i];
        }

        if ((10 - (Character.getNumericValue(sum.toString().charAt(sum.toString().length() - 1)))) == checkDigit) {
            return true;
        } else {
            return false;
        }

    }

}
