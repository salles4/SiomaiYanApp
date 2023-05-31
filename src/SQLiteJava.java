
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SQLiteJava {

    //connection to use in all commands
    public static Connection conn;

    //connects database 
    public static void ConnectDatabase() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:sqlite:src/data/database.db");
                if (conn != null) {
                    DatabaseMetaData meta = conn.getMetaData();
                    System.out.println("Connected to SQLite database "
                            + meta.getDatabaseProductName() + " " + meta.getDatabaseProductVersion());
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
                JOptionPane.showMessageDialog(null, "Databse not connected\nCheck Output");
                System.exit(0);
            }
        }
    }

    //adds data from database to the given arrayList
    public static void SQLiteRS(String command, ArrayList array) {
        array.clear();
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM (" + command + ") where visible = 1");
            if (rs.next()) {
                do {
                    String[] row = {rs.getString("id"), rs.getString("name"),
                        rs.getString("password")};
                    array.add(row);
                } while (rs.next());
            } else {
                System.out.println("Empty Data");
            }
            System.out.println("Data Listed.");
        } catch (SQLException e) {
            showError(e);
        }
    }

    //adds the data from database to the given panel
    public static void SQLiteRS(String command, javax.swing.JPanel panel) {
        panel.removeAll();
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM (" + command + ") where visible = 1");
            if (rs.next()) {
                do {
                    String[] row = {rs.getString("id"), rs.getString("name"),
                        rs.getString("password")};
                    panel.add(new ItemPanel(row));
                } while (rs.next());
            } else {
                System.out.println("Empty Data");
            }
            System.out.println("Data Listed.");
        } catch (SQLException e) {
            showError(e);
        }
        panel.revalidate();
        panel.repaint();
    }

    //adds data to database through prepare statement for better security
    public static void SQLitePrepare(String PreparedCommand, String[] setData) {
        try (PreparedStatement pStmt = conn.prepareStatement(PreparedCommand)) {
            for (int i = 0; i < setData.length; i++) {
                pStmt.setString(i + 1, setData[i]);
            }
            pStmt.executeUpdate();
        } catch (SQLException e) {
            showError(e);
        }
    }

    //run given command to database
    public static void SQLite(String command) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(command);
        } catch (SQLException e) {
            showError(e);
        }
    }

    //returns boolean if a value exists in command given
    public static boolean SQLiteCheckIfInDatabase(String command, String[] value) {
        try (PreparedStatement userCheck = conn.prepareStatement(command)) {
            for (int i = 0; i < value.length; i++) {
                userCheck.setString(i + 1, value[i]);
            }
            ResultSet rsUser = userCheck.executeQuery();
            return rsUser.next();
        } catch (SQLException ex) {
            showError(ex);
        }
        return false;
    }
    public static boolean SQLiteCheckIfInDatabase(String command, String value) {
        try (PreparedStatement userCheck = conn.prepareStatement(command)) {
                userCheck.setString(1, value);
            ResultSet rsUser = userCheck.executeQuery();
            return rsUser.next();
        } catch (SQLException ex) {
            showError(ex);
        }
        return false;
    }

    public static boolean SQLiteLogIn(String user, String pass) {
        boolean haveAcc = false;
        try (PreparedStatement credCheck = conn.prepareStatement("select * from accounts where "
                + "name=? and password=? and visible = 1")) {
            credCheck.setString(1, user);
            credCheck.setString(2, pass);
            ResultSet rs = credCheck.executeQuery();
            if (rs.next()) {
                haveAcc = true;
                accDetails.username = rs.getString("name");
                accDetails.accnumber = rs.getString("id");
                accDetails.admin = false;
            }
        } catch (SQLException ex) {
            showError(ex);
        }
        return haveAcc;
    }

    //displays joptionpane for catching error
    private static void showError(SQLException e) {
        JOptionPane.showMessageDialog(null, e, "DATABASE ERROR", JOptionPane.ERROR_MESSAGE);
    }
}
