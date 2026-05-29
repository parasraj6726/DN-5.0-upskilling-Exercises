// Q31: Basic JDBC Connection (SQLite example — no external server needed)
// To run: add sqlite-jdbc JAR to classpath, e.g.:
//   javac -cp .:sqlite-jdbc.jar BasicJDBCConnection.java
//   java  -cp .:sqlite-jdbc.jar BasicJDBCConnection

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BasicJDBCConnection {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:school.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // Create table and insert sample data if not exists
            stmt.execute("CREATE TABLE IF NOT EXISTS students " +
                         "(id INTEGER PRIMARY KEY, name TEXT, grade TEXT)");
            stmt.execute("INSERT OR IGNORE INTO students VALUES (1, 'Alice', 'A')");
            stmt.execute("INSERT OR IGNORE INTO students VALUES (2, 'Bob', 'B')");
            stmt.execute("INSERT OR IGNORE INTO students VALUES (3, 'Charlie', 'C')");

            // Query and display
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            System.out.println("ID  | Name     | Grade");
            System.out.println("----|----------|------");
            while (rs.next()) {
                System.out.printf("%-3d | %-8s | %s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("grade"));
            }

        } catch (Exception e) {
            System.out.println("JDBC Error: " + e.getMessage());
        }
    }
}
