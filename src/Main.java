import java.util.Scanner;

/**
 * @author Aidan Harley
 * @version 1.0
 * Section 2
 * I pledge that I have neither given nor recieved unauthorized assistance on this assignment.
 *
 *
 */

public class Main {

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        System.out.print("Enter the number of parts you would like to put in the inventory: ");
        int count = stdin.nextInt();
        stdin.nextLine();
        String[] breaker = {"", "", "", "", ""};
        BikePart_ABH[] bpArray = new BikePart_ABH[count];


        for (int x = 0; x < count; x++) {
            breaker = stdin.nextLine().split(",");
            String a = breaker[0];
            String b = breaker[1];
            double c = Double.parseDouble(breaker[2]);
            double d = Double.parseDouble(breaker[3]);
            boolean e = Boolean.parseBoolean(breaker[4]);
            bpArray[x] = new BikePart_ABH(a, b, c, d, e);
        }

        for(int x = 0; x < count; x++) {
            if (bpArray[x].listPrice < 20.00) {
                bpArray[x].printPart();
            }
        }
    }
}

