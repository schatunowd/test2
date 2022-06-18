package forms;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TableToXML{

    private static final String login = "root";
    private static final String passwd = "Dima1837!";
    private static final String host = "jdbc:mysql://localhost:3306/stuff";
    private static String tableName = null;

    public TableToXML(String tablename){
        this.tableName = tablename;
    }

    public static String getTableData() throws SQLException, ClassNotFoundException {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection( host, login, passwd);

            st = con.createStatement();
            rs = st.executeQuery("select * from " + tableName);

            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();

            StringBuilder b = new StringBuilder("<table>\n");

            int num = 1;
            while (rs.next()) {
                b.append("<row>");
                b.append("<num>").append(num++).append("</num>");
                for (int i = 1; i <= colCount; i++) {
                    String columnName = rsmd.getColumnName(i);
                    b.append('<').append(columnName).append('>');
                    b.append(rs.getObject(i));
                    b.append("</").append(columnName).append('>');
                }
                b.append("</row>\n");
            }
            b.append("</table>");
            return b.toString();
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            if (st != null)
                try {
                    st.close();
                } catch (SQLException e) {
                }
            if (con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                }
        }
    }

    public static void SaveXML(String tableName,  JFrame mainFrame)
    {
        String answer;
        try {
            TableToXML a = new TableToXML(tableName);
            answer = a.getTableData();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        FileDialog fDialog = new FileDialog(mainFrame, "Сохранить " + tableName + "в XML", FileDialog.SAVE);
        fDialog.setVisible(true);
        String path = fDialog.getDirectory() + fDialog.getFile();
        File f = new File(path);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(f);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        writer.println(answer);
        writer.close();
        try {
            f.createNewFile();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String args[]) throws SQLException, ClassNotFoundException {

    }
}