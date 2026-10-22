package parking.refactored;

import java.util.List;

public interface ReportReceiptFormatter {

    public String formatReceipt(Vehicle vehicle, int hours, double fee, PaymentMethod method) ;
    public String formatDailyReport(List<String> receipts, double total) ;
    public String formatCashCancellation(Vehicle vehicle, double amount) ;
}