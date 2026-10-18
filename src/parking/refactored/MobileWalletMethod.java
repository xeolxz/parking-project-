package parking.refactored;

public class MobileWalletMethod implements RefundablePaymentMethod{
    public String name() { return "MOBILE WALLET"; }
    @Override
    public void pay(double amount) {
        System.out.println("[Mobile wallet] paid " + amount + " MAD");
    }
    @Override
    public void refund(double amount) {
        System.out.println("[Mobile wallet] refunded " + amount + " MAD");
    }
}
