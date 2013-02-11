package Model;

import java.text.NumberFormat;

public class FoodTicket {

    public static final double TAX = 0.055;
    private double tipPercentage = 0.15;
    private int comboOneOrders = 0;
    private int comboTwoOrders = 0;
    private double subtotal = 0.0;
    private double total = 0.0;

    public double getTip() {
        return tipPercentage;
    }

    public void setTip(double tip) {
        this.tipPercentage = tip;
    }

    public void addItemToOrder(String item) {
        if (item.equalsIgnoreCase("comboOne")) {
            this.comboOneOrders += 1;
        } else if (item.equalsIgnoreCase("comboTwo")) {
            this.comboTwoOrders += 1;
        }
        updateSubTotal();
    }

    private void updateSubTotal() {
        double comboOneTotal = ComboOne.PRICE * comboOneOrders;
        double comboTwoTotal = ComboTwo.PRICE * comboTwoOrders;

        this.subtotal = comboOneTotal + comboTwoTotal;
    }

    private void calculateTotal() {
        double totalWithNoTip = (subtotal * TAX) + subtotal;
        total = (totalWithNoTip * tipPercentage) + totalWithNoTip;
    }

    public String getReceipt() {
        calculateTotal();
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(total);
        return moneyString;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.total) ^ (Double.doubleToLongBits(this.total) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FoodTicket other = (FoodTicket) obj;
        if (Double.doubleToLongBits(this.total) != Double.doubleToLongBits(other.total)) {
            return false;
        }
        return true;
    }
}
