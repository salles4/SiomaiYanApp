
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public static Connection ConnDatabase() {
        ConnectDatabase();
        return conn;
    }

    //adds data from database to the given arrayList
    public static void SQLiteRS(String command, ArrayList AccountArray) {
        AccountArray.clear();
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM (" + command + ") where visible = 1");
            if (rs.next()) {
                do {
                    String[] row = {rs.getString("id"), rs.getString("user"),
                        rs.getString("password")};
                    AccountArray.add(row);
                } while (rs.next());
            } else {
                System.out.println("Empty Data");
            }
            System.out.println("Data Listed.");
        } catch (SQLException e) {
            showError(e);
        }
    }

    //adds data from database to the given arrayList
    public static void SQLiteRS(String command, ArrayList AccountArray, String[] dataToGet) {
        AccountArray.clear();
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM (" + command + ") where visible = 1");
            if (rs.next()) {
                do {
                    String[] row = new String[dataToGet.length];
                    for (int i = 0; i < dataToGet.length; i++) {
                        row[i] = rs.getString(dataToGet[i]);
                    }

                    AccountArray.add(row);
                } while (rs.next());
            } else {
                System.out.println("Empty Data");
            }
            System.out.println("Data Listed.");
        } catch (SQLException e) {
            showError(e);
        }
    }

    //adds data from database to the given arrayList
    public static void SQLiteRS(String command, String[] DatatoArray, String[] dataToGet) {
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM (" + command + ") where visible = 1");
            if (rs.next()) {
                for (int i = 0; i < dataToGet.length; i++) {
                    DatatoArray[i] = rs.getString(dataToGet[i]);
                }
            }
        } catch (SQLException e) {
            showError(e);
        }
    }
    /** runs a SQL command and return value in given column
     * 
     * @param command
     * @param column
     * @return 
     */
    public static String SQLiteRS(String command, String column) {
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery(command);
            if (rs.next()) {
                return rs.getString(column);
            }
        } catch (SQLException e) {
            showError(e);
        }
        return "null";
    }
    /** runs a SQL command and return the selected value
     * 
     * 
     * @param command specify column in select % from ...
     * @return 
     */
    public static String SQLiteSelect(String command) {
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery(command);
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            showError(e);
        }
        return "null";
    }
    /**adds the data from database to the given panel
     * 
     * @param command sqlCommand
     * @param panel Scroll Panel to add into
     */
    
    public static void SQLiteRS(String command, ProductsPanel panel) {
        panel.ScrollPanel.removeAll();
        try (Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM (" + command + ") where visible = 1");
            if (rs.next()) {
                do {
                    String[] row = {rs.getString("id"), rs.getString("name"),
                        rs.getString("amount"), rs.getString("price"), rs.getString("min_stock")};
                    panel.ScrollPanel.add(new ItemPanel(row, panel));
                } while (rs.next());
            } else {
                System.out.println("Empty Data");
            }
            System.out.println("Data Listed.");
        } catch (SQLException e) {
            showError(e);
        }
        panel.ScrollPanel.revalidate();
        panel.ScrollPanel.repaint();
    }

    /**adds data to database through prepare statement for better security
     * 
     * @param PreparedCommand sqlCommand
     * @param setData value to the ? in prepared command
     */
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
    
    /**
    *   run given command to database
     * @param command sqlCommand
    */            
    public static void SQLite(String command) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(command);
        } catch (SQLException e) {
            showError(e);
        }
    }
    public static int SQLiteExeUpdate(String command){
        try (Statement stmt = conn.createStatement()) {
            return stmt.executeUpdate(command);
        } catch (SQLException ex) {
            showError(ex);
        }
        return 0;
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

    //SQLiteCheckIfInDatabase("select * from acc where user = ?", username) returns true if database contain value
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
                + "user=? and password=? and visible = 1")) {
            credCheck.setString(1, user);
            credCheck.setString(2, pass);
            ResultSet rs = credCheck.executeQuery();
            if (rs.next()) {
                haveAcc = true;
                accDetails.username = rs.getString("user");
                accDetails.accnumber = rs.getString("id");
                accDetails.name = rs.getString("name");
                int admin = rs.getInt("admin");
                accDetails.admin = (admin != 0) ;
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
