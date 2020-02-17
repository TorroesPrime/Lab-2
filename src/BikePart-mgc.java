/*   CPSC_240: Obj-Oriented Analysis & Design Section: 202001
I, as a new member of the University of Mary Washington community, pledge not to lie, cheat, or steal and to
 actively contribute to a community of trust. I understand that honor is a way of life at Mary Washington and that
 my words and deeds impact the lives of others. As a Mary Washington student, I therefore promise to hold myself to
 the highest standards of honesty and integrity in all that I do and say.

 I further pledge that I will endeavor to create a spirit of honor, both by upholding the Honor System myself and
 helping others to do so.

 Signed: Michael G. Cividanes 2-3-2020
 */
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;  // Import the Scanner class
/**
 * @author Michael Cividanes
 * Represents a bike part to be added to a list with other parts.
 */
public class BikePart_mgc {

   static Scanner userInput = new Scanner(System.in);
   private String partName;
   private String partNumber;
   private double listPrice;
   private double salesPrice;
   private boolean onSale;
    BikePart_mgc(String p, String Num, double price, double sale, boolean status){
    this.partName = p;
    this.partNumber = Num;
    this.listPrice = price;
    this.salesPrice = sale;
    this.onSale = status;
   }
    /** get the name of the part
    * @return String:part name
     */
   public String getPartName()
   {
       return this.partName;
   }
   /** get the Part number of the part.
     *@return String: partnumber
     */
   public String getPartNumber(){

        return this.partNumber;
    }
    /** get the listed price e of the part.
     @return double: listPrice
     */
    public double getListPrice(){

        return this.listPrice;
    }
    /** get the sale price of the part.
     @return double: salesPrice
     */
    public double getSalesPrice(){
        return this.salesPrice;
    }
    /** get the current sale status of the part.
     @return boolean: onSale
     */
    public String getSaleStatus(){

        String saleStatutus;
       if(this.onSale)
       {saleStatutus = "On sale";}
        else
       {saleStatutus = "Not on sale";}
        return saleStatutus;
    }
    /** sets the supplied string as the name of the part.
     * @param partName String that is the part name
     */
    public void setPartName(String partName){

    this.partName = partName;
    }
    /** sets the supplied string as the number of the part.
     * @param number String that is the part number
     */
    public void setpartNumber(String number){

        this.partName = number;
    }
    /** sets the supplied double as the list price of the part.
     * @param price Double that represents the normal price of the item.
     */
    public void setListPrice(double price){

       this.listPrice = price;
    }
    /** sets the supplied double as the sales price of the part.
     * @param price double that represents the on sale price of the item
     */
    public void setSalesPrice(double price){

       this.salesPrice = price;
    }
    /** sets the  onSale status of the part.
     */
    public void setSaleStatus() {

        System.out.print("Item: " + this.getPartName() + " is presently " + this.getSaleStatus() + ". Do you wish to change it's sale status? Press type '1' for yes, '2' for no.");
        int userAnswer = userInput.nextInt();
        while (userAnswer != 1 || userAnswer != 2) {
            System.out.println("You have entered an incorrect command. If you wish to change it's sale status? Press type '1' for yes, '2' for no.");
            if (userAnswer == 1) {
                if (this.getSaleStatus().equals("On sale"))
                    this.onSale = false;
            } else {
                this.onSale = true;
            }
        }
    }

    /** reads in from a file, builds inventory and then writes out to a new file.
     * @param fileName String that lists the location of the file to be read from
     */
public static ArrayList<BikePart_mgc> inventoryBuilder(String fileName) {
    Charset charset = StandardCharsets.US_ASCII;
    Path filePath = Paths.get(fileName);
    ArrayList<BikePart_mgc> inventory = new ArrayList<>();
    Path outputFile = Paths.get("C:\\Users\\Michael Cividanes\\OneDrive\\Documents\\School\\UMW\\Classes\\CPSC 240 Obj-Oriented Analysis & Design\\labs\\lab 3\\BikePartsInventory.txt");
    try (BufferedReader reader = Files.newBufferedReader(filePath, charset)) {
        String line = null;
        System.out.println("File found. Reading...");
        List<String> retList = Files.readAllLines(filePath, charset);

        int partCount = Integer.parseInt(retList.get(0));

        String regExp = "\\s*(\\s|,)\\s*";
        ArrayList<String> part = new ArrayList<>();
        for (int row = 1; row <= partCount; row++) {
            String lineitem = retList.get(row);
            String[] pv = lineitem.split(regExp);
            String partName = pv[0];
            String partNumber = pv[1];
            double listPrice = Double.parseDouble(pv[2]);
            double salePrice = Double.parseDouble(pv[3]);
            boolean saleStatus = Boolean.parseBoolean(pv[4]);
            BikePart_mgc itemEntry = new BikePart_mgc(partName, partNumber, listPrice, salePrice, saleStatus);
            inventory.add(itemEntry);
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(outputFile), false));
        for (BikePart_mgc bikePart_mgc : inventory) {
            String n = bikePart_mgc.getPartName();
            String num = bikePart_mgc.getPartNumber();
            double lp = bikePart_mgc.getListPrice();
            double sp = bikePart_mgc.getSalesPrice();
            String ss = bikePart_mgc.getSaleStatus();
            String s1 = bikePart_mgc.getPartName();
            String s2 = Double.toString(bikePart_mgc.getListPrice());
            String s3 = Double.toString(bikePart_mgc.getSalesPrice());
            String s4 = bikePart_mgc.getSaleStatus();
            String inventoryItem = s1 + "," + s2 + "," + s3 + "," + s4 + "\n";
            writer.write(inventoryItem);

            writer.flush();

        }
    } catch (IOException x) {
        System.err.format("IOException: %s%n", x);
    }
    return inventory;
}
    /** reads inventory file and creates a new file based on maximum price that includes items
     */
    public static void inventorySearch() throws IOException {
        System.out.println("Please enter a price to search for: ");
        double price = Double.valueOf(userInput.nextLine());
        String fileName = "C:\\Users\\Michael Cividanes\\OneDrive\\Documents\\School\\UMW\\Classes\\CPSC 240 Obj-Oriented Analysis & Design\\labs\\lab 3\\partsToRead.txt";
        String outputFile = "C:\\Users\\Michael Cividanes\\OneDrive\\Documents\\School\\UMW\\Classes\\CPSC 240 Obj-Oriented Analysis & Design\\labs\\lab 3\\inventorySearchWherePriceisLessThenOrequalto"+String.valueOf(price)+".txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(outputFile), false));
        ArrayList<BikePart_mgc> inventory = inventoryBuilder(fileName);
        String header = "The following items have a sale price of less then or equal to $"+String.valueOf(price)+"\n";
        writer.write(header);
        writer.flush();
        for (BikePart_mgc bikePart_mgc : inventory) {
            if(bikePart_mgc.getListPrice()<= price){
                String s1 = bikePart_mgc.getPartName();
                String s2 = Double.toString(bikePart_mgc.getListPrice());
                String s3 = Double.toString(bikePart_mgc.getSalesPrice());
                String s4 = bikePart_mgc.getSaleStatus();
                String inventoryItem = s1 + "," + s2 + "," + s3 + "," + s4 + "\n";
                writer.write(inventoryItem);
                writer.flush();
            }

            }
        }

        }


