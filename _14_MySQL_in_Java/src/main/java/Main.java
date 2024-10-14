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

            // Вызов метода для отображения информации
            displayEmployees(conn);

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

    // Метод для отображения данных сотрудников
    public static void displayEmployees(Connection conn) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Создание объекта Statement для выполнения запросов
            stmt = conn.createStatement();
            String sql = "SELECT * FROM employee";
            rs = stmt.executeQuery(sql);

            // Обработка результатов
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String secondName = rs.getString("secondName");
                String lastName = rs.getString("lastName");
                System.out.println("ID: " + id + ", Name: " + name + ", SecondName: " + secondName + ", LastName: " + lastName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Закрытие ResultSet и Statement
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
