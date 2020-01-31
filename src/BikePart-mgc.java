/*  CPSC_240: Obj-Oriented Analysis & Design Section: 202001
“I, as a new member of the University of Mary Washington community, pledge not to lie, cheat, or steal and to
 actively contribute to a community of trust. I understand that honor is a way of life at Mary Washington and that
 my words and deeds impact the lives of others. As a Mary Washington student, I therefore promise to hold myself to
 the highest standards of honesty and integrity in all that I do and say.

 I further pledge that I will endeavor to create a spirit of honor, both by upholding the Honor System myself and
 helping others to do so.”

 Signed: Michael G. Cividanes 1-22-2020
 */
import java.util.Scanner;  // Import the Scanner class
public class BikePart-mgc {
    Scanner userInput = new Scanner(System.in);
   private String partName;
   private String partNumber;
   private double listPrice;
   private double salesPrice;
   private boolean onSale;
    BikePart(String p, String Num, double price, double sale, boolean status){
    this.partName = p;
    this.partNumber = Num;
    this.listPrice = price;
    this.salesPrice = sale;
    this.onSale = status;
   }
   public String getPartName(){
       return this.partName;
   }
   public String getPartNumber(){
        return this.partNumber;
    }
    public double getListPrice(){
        return this.listPrice;
    }
    public double getSalesPrice(){
        return this.salesPrice;
    }
    public String getSaleStatus(){
        String saleStatutus ="";
       if(this.onSale == true)
       {saleStatutus = "On sale";}
        else
       {saleStatutus = "Not on sale";}
        return saleStatutus;
    }
    public void setPartName(String partName){
    this.partName = partName;
    }
    public void setpartNumber(String partNumber){
        this.partName = partName;
    }
    public void setListPrice(double price){
       this.listPrice = price;
    }
    public void setSalesPrice(double price){
       this.salesPrice = price;
    }
    public void setSaleStatus(){
       System.out.print("Item: "+this.getPartName()+" is presently "+this.getSaleStatus()+". Do you wish to change it's sale status? Press type '1' for yes, '2' for no.");
       int userAnswer = userInput.nextInt();
       while (userAnswer != 1 || userAnswer != 2)
        {System.out.println("You have entered an incorrect command. If you wish to change it's sale status? Press type '1' for yes, '2' for no.");
        if (userAnswer == 1){
        if(this.getSaleStatus().equals("On sale"))
        this.onSale = false;}
       else {
            this.onSale = true;
        }
        }

    }

    public static void main(String[] args) {
	// write your code here

        BikePart part0256 = new BikePart("WTB_saddle","1234567890",33.00,25.58,false);
       System.out.println(part0256.getSaleStatus());
       part0256.setSaleStatus();
    }
}
