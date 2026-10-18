package parking.refactored;

public class FakeLogger implements ReceiptLogger {
    @Override
    public void log(String line) {
        // Do nothing: no file or database is created.
    }
}