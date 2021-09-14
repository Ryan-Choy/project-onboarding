package main;

import java.util.Arrays;

public class EncryptDecimal {
    public static void main(String[] args) {
        EncryptDecimal encryptdecimal = new EncryptDecimal();
        System.out.println("Encrypting abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ with ROT13 method.");
        System.out.println(encryptdecimal.EncryptROT13("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        
        System.out.println("Converting 1234 to octal.");
        System.out.println(encryptdecimal.DecimalToOctal(1234L));
    }

//    1) Write a program to encrypt a message using the ROT13 technique. 
    public String EncryptROT13(String message) {
        String encrypt = "";
        int ascii = 0;
        char[] convert = message.toCharArray();
        if (!message.matches("[A-Za-z]+")) {
            encrypt = "Invaid input!";
        } else {
            for (int i = 0; i < message.length(); i++) {
                if ((convert[i] >= 'a' && convert[i] <= 'm') || (convert[i] >= 'A' && convert[i] <= 'M')) {
                    convert[i] += 13;
                } else {
                    convert[i] -= 13;
                }
            }
            encrypt = String.valueOf(convert);
        }
        return encrypt;
    }

//    2) Write a program to convert a decimal number to its octal equivalent.
    public String DecimalToOctal(Long input) {
        return Long.toOctalString(input);
    }

}
