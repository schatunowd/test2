import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TableToXML{

    private final String login = "root", passwd = "Dima1837!", host = "jdbc:mysql://localhost:3306/stuff", tableName;

    public TableToXML(String tablename){
        this.tableName = tablename;
    }

    public String getTableData() throws SQLException, ClassNotFoundException {
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
            Date date = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            String fileName = tableName + "_" + formatForDateNow.format(date) + ".xml";
            File f = new File("D:\\study\\intellij idea\\test2\\xml\\" + fileName);
            f.createNewFile();
            PrintWriter writer = new PrintWriter(f);
            writer.println(b);
            writer.close();
            return b.toString();
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw new RuntimeException(e);
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

    public static void main(String args[]) throws SQLException, ClassNotFoundException {

    }
}