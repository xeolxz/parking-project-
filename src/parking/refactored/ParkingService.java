package parking.refactored;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParkingService {

    private final PaymentService paymentService;
    private final ReportReceiptFormatter formatter;
    private final ReceiptLogger logger;

    private final List<String> receipts = new ArrayList<>();
    private double total;

    public ParkingService(
            PaymentService paymentService,
            ReportReceiptFormatter formatter,
            ReceiptLogger logger) {

        this.paymentService = paymentService;
        this.formatter = formatter;
        this.logger = logger;
    }

    public double fee(Vehicle vehicle, int hours, VehicleTariff tariff) {
        if (vehicle == null || tariff == null) {
            throw new IllegalArgumentException(
                    "Vehicle and tariff cannot be null");
        }
        if (hours < 0) {
            throw new IllegalArgumentException(
                    "Hours cannot be negative");
        }

        return tariff.fee(hours);
    }

    public void checkout(Vehicle vehicle, int hours, PaymentMethod method, VehicleTariff tariff)
            throws IOException {
        double amount = fee(vehicle, hours, tariff);
        paymentService.checkout(method, amount);
        total += amount;
        String receipt = formatter.formatReceipt(vehicle, hours, amount, method);
        receipts.add(receipt);
        logger.log(receipt);
    }

    public void cancel(Vehicle vehicle, int hours, RefundablePaymentMethod method, VehicleTariff tariff) throws IOException {

        double amount = fee(vehicle, hours, tariff);

        paymentService.cancel(method, amount);

        total -= amount;
    }

    public String dailyReport() {
        return formatter.formatDailyReport(receipts, total);
    }
}