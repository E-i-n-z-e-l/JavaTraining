import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // Параметры подключения
        String url = "jdbc:mysql://localhost:3306/test_java";
        String user = "root";
        String password = "__1q2w3e4r5t6y7u8i9o__";

        Connection conn = null;
        Statement stmt = null;

        try {
            // Подключение к базе данных
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Подключение успешно!");

            // Создание объекта Statement для выполнения запросов
            stmt = conn.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(sql);

            // Обработка результатов
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

            // Закрытие ResultSet
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Закрытие ресурсов
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
