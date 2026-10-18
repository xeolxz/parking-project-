package parking.refactored;

import java.util.List;

public class CsvReportFormatter {

    public String format(List<String> receipts, double total) {
        StringBuilder sb = new StringBuilder();

        sb.append("Plate,Vehicle Type,Hours,Amount,Payment Method\n");

        for (String receipt : receipts) {
            String[] parts = receipt.split(" \\| ");
            sb.append(String.join(",", parts)).append("\n");
        }

        sb.append("Total,,,,").append(total).append(" MAD");

        return sb.toString();
    }
}