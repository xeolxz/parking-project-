package parking.refactored;


public class PaymentService {

    public void checkout(PaymentMethod method, double amount) {
        method.pay(amount);
    }

    public void cancel(RefundablePaymentMethod method, double amount) {
        method.refund(amount);
    }
}
