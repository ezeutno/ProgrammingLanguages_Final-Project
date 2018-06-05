package sample;
import java.sql.*;

public class Database {
    private Connection conn;
    private Statement stm;
    private ResultSet rs;
    private int uq;
    private String url ;
    private String user = "root";
    private String pass = "";

    public Database(){
        setURL("localhost");
        connectDB();
    }

    public void connectDB() {
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setURL(String location){
        url = "jdbc:mysql://"+location+"/pl_finalproject";
    }

    public int getTotalData() {
        try {
            String query = "SELECT count(*) FROM rating";
            rs = stm.executeQuery(query);
            rs.next();
            return rs.getInt(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public ResultSet getData() {
        try {
            String query = "SELECT rating_code, count(*) FROM rating GROUP BY rating_code";
            rs = stm.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public int getCountRating(int rating_code) {
        try {
            String query = "SELECT rating_code, count(*) FROM rating WHERE rating_code = "+rating_code;
            rs = stm.executeQuery(query);
            rs.next();
            return rs.getInt(2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public ResultSet getData(Timestamp start_date, Timestamp end_date) {
        try {
            String query = "SELECT rating_code, count(*) FROM rating WHERE rating_timestamp >= "
                    +start_date+" AND rating_timestamp <= "+end_date+" GROUP BY rating_code";
            rs = stm.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
}
