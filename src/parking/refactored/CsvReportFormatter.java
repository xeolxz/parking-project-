package parking.refactored;

import java.util.List;

public class CsvReportFormatter implements ReportReceiptFormatter{
    @Override
    public String formatReceipt(Vehicle vehicle, int hours, double fee, PaymentMethod method) {
        return vehicle.getPlate() + ","
                + vehicle.getType() + ","
                + hours + ","
                + fee + ","
                + method.name();
    }

    @Override
    public String formatDailyReport(List<String> receipts, double total) {
        StringBuilder sb = new StringBuilder();
        sb.append("Plate,Vehicle Type,Hours,Amount,Payment Method\n");

        for (String receipt : receipts) {
            sb.append(receipt).append("\n");
        }

        sb.append("Total,,,,").append(total).append("\n");
        return sb.toString();
    }

    @Override
    public String formatCashCancellation(Vehicle vehicle, double amount) {
        return "Plate,Action,Amount\n"
                + vehicle.getPlate() + ",Cash refund at desk," + amount;
    }




}
