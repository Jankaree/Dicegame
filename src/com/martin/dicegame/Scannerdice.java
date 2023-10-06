package com.martin.dicegame;

public class Scannerdice {

    public static int scanInteger(){
        int loop = 0;

        while(loop <= 0) {
            String input = scannerText();

            try {
                int input2 = Integer.parseInt(input);
                loop = Integer.parseInt(input);
            } catch (NumberFormatException var14) {
                System.out.println("Please only input a whole number or a number that is not zero or negative");
            }

        }
        return loop;
    }


    public static String scannerText(){
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        String input = scanner.nextLine();

        return input;
    }
}


