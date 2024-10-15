import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Параметры подключения
        String url = "jdbc:mysql://localhost:3306/test_java"; // URL базы данных;
        String user = "root";                                 // Имя пользователя базы данных;
        String password = "__1q2w3e4r5t6y7u8i9o__";           // Пароль пользователя от базы данных;

        Connection conn = null; // Переменная соединения. При создании отсутствует(пуста);
        Statement stmt = null;  //

        // Используем try-catch для поимки возможной ошибки;
        try {
            // Метод DriverManager.getConnection() используется для установления соединения с базой данных;
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Подключение успешно!");
            // addEmployee(conn, "Иван", "Иванович", "Иванов"); // Добавляем сотрудника;
            displayEmployees(conn); // Вызов метода для отображения информации;
            // deleteEmployee(conn, 5); // Удаляем добавленного сотрудника;
            updateEmployee(conn, 6, "Георгий", "Георгиевич", "Георгиев"); // Изменяем данные сотрудника;
            displayEmployees(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // В блоке finally закрываются ресурсы: Connection, Statement и ResultSet, если они были открыты.
                    // Это важно для предотвращения утечек памяти.
            try {
                // Закрытие ресурсов
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    /**
     * Метод выполняет SQL-запрос для извлечения данных из таблицы employee.
     * @param conn параметр соединения с базой данных;
     */
    public static void displayEmployees(Connection conn) {
        Statement stmt = null; // Этот объект будет использоваться для выполнения SQL-запросов к базе данных;
        ResultSet rs = null;   // Этот объект будет хранить результаты, возвращаемые SQL-запросом;

        try {
            // Создание объекта Statement для выполнения запросов
            stmt = conn.createStatement(); // объект Statement позволяет выполнять простые SQL-запросы без параметров;
            String sql = "SELECT * FROM employee"; // Создаем запрос отображения всей таблицы;
            rs = stmt.executeQuery(sql); // Метод executeQuery() выполняет SQL-запрос и возвращает результаты в объект ResultSet;

            // Обработка результатов
            while (rs.next()) { // Метод next() перемещает курсор к следующей строке результата. Метод вернет false, когда больше строк не будет;
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String secondName = rs.getString("secondName");
                String lastName = rs.getString("lastName");
                System.out.println("ID: " + id + ", Name: " + name + ", SecondName: " + secondName + ", LastName: " + lastName);
            }

        }
        /* Если в процессе выполнения запросов происходит ошибка (например, проблемы с соединением,
        некорректный SQL-запрос и т. д.), то SQLException будет пойман, и будет выведен стек вызовов
        ошибки, что поможет диагностировать проблему. */
        catch (SQLException e) {
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

    /**
     * Метод для добавления нового сотрудника.
     * @param conn параметр соединения
     * @param name имя
     * @param secondName отчество
     * @param lastName фамилия
     */
    public static void addEmployee(Connection conn, String name, String secondName, String lastName) {
        String sql = "INSERT INTO employee (name, secondName, lastName) VALUES (?, ?, ?)"; // символ ? как заполнители для параметров;
        // автоматически закроет `PreparedStatement`, когда он выйдет из области видимости;
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Установка параметров
            pstmt.setString(1, name);
            pstmt.setString(2, secondName);
            pstmt.setString(3, lastName);

            // Выполнение запроса
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Сотрудник добавлен, затронуто строк: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для удаления сотрудника.
     * @param conn параметр подключения к базе данных
     * @param id уникальный id сотрудника
     */
    public static void deleteEmployee(Connection conn, int id) {
        String sql = "DELETE FROM employee WHERE id = ?"; // Запрос удаляет запись из таблицы employee, где совпадает указанный id;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Установка параметра
            pstmt.setInt(1, id); // Метод setInt устанавливает значение id в запросе.
                                               // Этот параметр будет заменен на значение, переданное в метод;
            // Выполнение запроса
            int rowsAffected = pstmt.executeUpdate();// Метод executeUpdate() выполняет SQL-запрос на удаление записи,
                                                     // и возвращает количество затронутых строк;
            System.out.println("Сотрудник удален, затронуто строк: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для изменения данных о сотруднике.
     * @param conn параметр соединения с базой данных;
     * @param id уникальный id сотрудника
     * @param name имя сотрудника
     * @param secondName отчество сотрудника
     * @param lastName фамилия сотрудника
     */
    public static void updateEmployee(Connection conn, int id, String name, String secondName, String lastName) {
        /* Запрос обновляет записи в таблице employee, установив новые значения для name, secondName и lastName,
        где совпадает указанный id */
        String sql = "UPDATE employee SET name = ?, secondName = ?, lastName = ? WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Установка параметров
            pstmt.setString(1, name);
            pstmt.setString(2, secondName);
            pstmt.setString(3, lastName);
            pstmt.setInt(4, id);

            // Выполнение запроса
            int rowsAffected = pstmt.executeUpdate(); // Метод executeUpdate() выполняет SQL-запрос на обновление,
                                                      // и возвращает количество измененных строк;
            System.out.println("Данные сотрудника изменены, затронуто строк: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}