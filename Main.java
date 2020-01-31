/**
 * Takes the input from user about BikeParts.
 * Returns input to the screen along with items <20$
 *
 * @author Joseph Ritter
 * @version 1.0
 * @since 2020-1-29
 */


package com.company;
import java.util.Scanner;

public class Main {
    /**
     *
     * Takes input from user.
     * Saves input to string array
     * Prints String array
     * Parses String array and adds it to BikeParts array
     * Prints items <20$
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter # of lines");
        int lineNum = input.nextInt();
        System.out.println(lineNum);
        String[] lines = new String[lineNum];
        BikePart[] parts = new BikePart[4];


        for (int i = 0; i < lineNum; i++) {
            lines[i] = input.next();
        }

        for (int i = 0; i < lineNum; i++) {
            System.out.println(lines[i]);
        }


        for (int i = 0; i < lineNum; i++) {
            String[] temp = lines[i].split(",");
            BikePart a = new BikePart();
            a.setPartName(temp[0]);
            a.setPartNumber(Integer.parseInt(temp[1]));
            a.setPrice(Double.parseDouble(temp[2]));
            a.setSalesPrice((Double.parseDouble(temp[3])));
            a.setOnSale(Boolean.valueOf(temp[4]));
            parts[i] = a;

        }

        for (int i = 0; i < lineNum; i++) {
            if (parts[i].getPrice() < 20) {
                System.out.println(parts[i]);
            }
        }


    }
}
