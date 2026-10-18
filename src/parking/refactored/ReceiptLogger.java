package parking.refactored;

import java.io.IOException;

public interface ReceiptLogger {
    public void log(String line) throws IOException;
}
