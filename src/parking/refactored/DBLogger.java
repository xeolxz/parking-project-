package parking.refactored;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBLogger implements ReceiptLogger {

    private final String url;
    private final String username;
    private final String password;

    public DBLogger(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public void log(String line) throws IOException {
        String sql = "INSERT INTO receipts (message) VALUES (?)";

        try (Connection connection =
                     DriverManager.getConnection(url, username, password);
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, line);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new IOException("Failed to log receipt to database", e);
        }
    }
}