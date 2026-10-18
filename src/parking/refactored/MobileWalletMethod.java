package parking.refactored;

public class MobileWalletMethod implements RefundablePaymentMethod{
    public String name() { return "MOBILE WALLET"; }

    public void pay(double amount) {
        System.out.println("[Mobile wallet] paid " + amount + " MAD");
    }

    public void refund(double amount) {
        System.out.println("[Mobile wallet] refunded " + amount + " MAD");
    }
}
