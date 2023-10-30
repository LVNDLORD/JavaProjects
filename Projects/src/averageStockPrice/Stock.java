public class Stock {
    private int shares;
    private double price, capital;

    public void buy(double purchasePrice, int sharesAmount) {
        shares += sharesAmount;
        price = purchasePrice;
        capital += sharesAmount * purchasePrice;
    }

    public void sell(double sellingPrice, int sharesAmount) {
        shares -= sharesAmount;
        price = sellingPrice;
        capital -= sharesAmount * sellingPrice;
    }

    public int getShares() {
        return shares;
    }

    public double getPrice() {
        return price;
    }

    public double getAveragePrice() {
        return capital / getShares();
    }
}
