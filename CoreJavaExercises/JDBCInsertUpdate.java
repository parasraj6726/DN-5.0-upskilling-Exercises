// Q32: Insert and Update Operations in JDBC (SQLite)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsertUpdate {

    static class StudentDAO {
        private Connection conn;

        StudentDAO(Connection conn) {
            this.conn = conn;
        }

        void insertStudent(int id, String name, String grade) throws SQLException {
            String sql = "INSERT OR IGNORE INTO students (id, name, grade) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, grade);
                int rows = ps.executeUpdate();
                System.out.println("Inserted " + rows + " row(s): [" + id + ", " + name + ", " + grade + "]");
            }
        }

        void updateStudentGrade(int id, String newGrade) throws SQLException {
            String sql = "UPDATE students SET grade = ? WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, newGrade);
                ps.setInt(2, id);
                int rows = ps.executeUpdate();
                System.out.println("Updated " + rows + " row(s): student id=" + id + " -> grade=" + newGrade);
            }
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlite:school.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            // Ensure table exists
            conn.createStatement().execute(
                "CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT, grade TEXT)");

            StudentDAO dao = new StudentDAO(conn);
            dao.insertStudent(4, "Diana", "B");
            dao.insertStudent(5, "Eve", "A");
            dao.updateStudentGrade(4, "A+");

        } catch (Exception e) {
            System.out.println("JDBC Error: " + e.getMessage());
        }
    }
}
