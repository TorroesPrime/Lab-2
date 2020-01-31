
/**
 * Represents a bike part to be added to a list with other parts.
 */
public class BikePart_ABH {

    //Fields
    public String partName;
    public String partNumber;
    public double listPrice;
    public double salesPrice;
    public boolean onSale;

    /**
     * Creates a new bike part.
     * @param partName Name of the part.
     * @param partNumber Number of the part.
     * @param listPrice Price of the part.
     * @param salesPrice Price of the part when on sale.
     * @param onSale Whether or not this part is on sale.
     */
    public BikePart_ABH(String partName, String partNumber, double listPrice, double salesPrice, boolean onSale) {
        this.partName = partName;
        this.partNumber = partNumber;
        this.listPrice = listPrice;
        this.salesPrice = salesPrice;
        this.onSale = onSale;
    }

    /**
     * Prints the full information list about the part.
     */
    public void printPart() {
        System.out.println(partName +","+ partNumber +","+ listPrice +","+ salesPrice +","+ onSale);
    }
}