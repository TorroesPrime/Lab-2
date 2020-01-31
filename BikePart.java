package com.company;

public class BikePart {
    /**
     * @param partName This is the name of the Bikepart
     * @param partNumber This is the number of the Bikepart
     * @param price This is the price of the Bikepart
     * @param salesPrice This is the price of the item on sale
     * @param onSale this is the value if the item is on sale
     * The most of the methods are setters and getters
     *
     */
    private String partName;
    private int partNumber;
    private double price;
    private double salesPrice;
    private boolean onSale;

    public BikePart() {
    }
    public BikePart(String partName, int partNumber, double price, double salesPrice, boolean onSale) {
        this.partName = partName;
        this.partNumber = partNumber;
        this.price = price;
        this.salesPrice = salesPrice;
        this.onSale = onSale;
    }
    public void setPartName(String x) { this.partName = x; }
    public String getPartName() {
        return this.partName;
    }
    public void setPartNumber(int x) {
        this.partNumber = x;
    }
    public int getPartNumber() {
        return this.partNumber;
    }
    public void setPrice(double x) {
        this.price = x;
    }
    public double getPrice() {
        return this.price;
    }
    public void setSalesPrice(double x) {
        this.salesPrice = x;
    }
    public double getSalesPrice() {
        return this.salesPrice;
    }
    public void setOnSale(boolean x) {
        this.onSale = x;
    }
    public boolean getOnSale() {
        return this.onSale;
    }
    public String toString() {
        return("name: " + partName + " id: " + partNumber + " price: " + price);
    }

}