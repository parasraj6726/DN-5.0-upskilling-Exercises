// Q33: Transaction Handling in JDBC (SQLite)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTransaction {

    static void transfer(Connection conn, int fromId, int toId, double amount) throws SQLException {
        conn.setAutoCommit(false);
        try {
            String debit  = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            String credit = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

            try (PreparedStatement debitStmt = conn.prepareStatement(debit);
                 PreparedStatement creditStmt = conn.prepareStatement(credit)) {

                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromId);
                debitStmt.executeUpdate();

                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toId);
                creditStmt.executeUpdate();
            }

            conn.commit();
            System.out.println("Transfer of " + amount + " from account " + fromId
                    + " to account " + toId + " completed successfully.");
        } catch (SQLException e) {
            conn.rollback();
            System.out.println("Transfer failed, rolled back: " + e.getMessage());
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlite:bank.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS accounts " +
                         "(id INTEGER PRIMARY KEY, name TEXT, balance REAL)");
            stmt.execute("INSERT OR IGNORE INTO accounts VALUES (1, 'Alice', 1000.0)");
            stmt.execute("INSERT OR IGNORE INTO accounts VALUES (2, 'Bob',   500.0)");

            transfer(conn, 1, 2, 200.0);  // successful transfer
            transfer(conn, 2, 1, 9999.0); // will succeed structurally (no balance check here)

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
