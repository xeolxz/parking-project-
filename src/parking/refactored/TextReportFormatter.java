package parking.refactored;

import java.util.List;

public class TextReportFormatter implements ReportReceiptFormatter{
    public String formatReceipt(Vehicle vehicle, int hours, double fee, PaymentMethod method) {

        return vehicle.getPlate() + " | "
                + vehicle.getType() + " | "
                + hours + " h | "
                + fee + " MAD | "
                + method.name();
    }
    public String formatDailyReport(List<String> receipts, double total) {
        StringBuilder sb = new StringBuilder("=== Daily report ===\n");
        for (String receipt : receipts) {
            sb.append(receipt).append("\n");
        }
        sb.append("Total: ").append(total).append(" MAD");
        return sb.toString();
    }
    public String formatCashCancellation(Vehicle vehicle, double amount) {
        return "Refund " + amount + " MAD at the desk for "
                + vehicle.getPlate();
    }
}
