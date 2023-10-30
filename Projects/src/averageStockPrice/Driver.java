public class Driver {

    public static void main(String[] args) {
        Stock abcCompany = new Stock();
        abcCompany.buy(36.66, 2000);
        abcCompany.buy(39.7, 3000);
        abcCompany.sell(43.9, 1000);
        System.out.println(abcCompany.getShares() + " total shares");
        System.out.println(abcCompany.getPrice() + " price of the latest transaction per share");
        System.out.println(abcCompany.getAveragePrice() + " total average price");
    }
}
