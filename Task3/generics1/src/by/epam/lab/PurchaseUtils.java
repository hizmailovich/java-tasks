package by.epam.lab;

public class PurchaseUtils <T extends Priceable>{
    private Purchase<T> purchase;

    public PurchaseUtils() {

    }

    public PurchaseUtils(Purchase<T> purchase) {
        this.purchase = purchase;
    }

    public PurchaseUtils(T item, Number quantity){
        this.purchase = new Purchase<T>(item, quantity);
    }

    public Purchase<T> getPurchase() {
        return purchase;
    }

    public void printPurchase() {
        System.out.println(purchase);
    }

    public void printCost() {
        System.out.println("Cost = " + purchase.getCost());
    }

    public void printCostDiff(Purchase<T> p) {
        int thisCost = purchase.getCost().getRubs() * 100 + purchase.getCost().getCoins();
        int otherCost = p.getCost().getRubs() * 100 + p.getCost().getCoins();
        char sign = ' ';
        Byn costDiff = new Byn(0);
        if (thisCost > otherCost) {
            sign = '+';
            costDiff = purchase.getCost().sub(p.getCost());
        } else if (thisCost < otherCost) {
            sign = '-';
            costDiff = p.getCost().sub(purchase.getCost());
        }
        System.out.println(sign + " diff = " + costDiff + " BYN");
    }

    public void printIsSameCost(Purchase<?>... purchases) {
        boolean isNotFound = true;
        System.out.println("Purchases with the same cost: ");
        for (Purchase p : purchases) {
            if (purchase.getCost().equals(p.getCost())) {
                System.out.println(p);
                isNotFound = false;
            }
        }
        if(isNotFound){
            System.out.println("Not found");
        }
    }
}
