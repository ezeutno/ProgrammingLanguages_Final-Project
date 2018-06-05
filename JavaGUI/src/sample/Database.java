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

    public int getRatingCount(int rating_code, String start_time, String end_time) {
        try {
            String query = "SELECT count(*) FROM rating WHERE rating_code = "+rating_code+" AND rating_timestamp >= '"
                    +start_time+" 00:00:00' AND rating_timestamp <= '"+end_time+" 23:59:59'";
            rs = stm.executeQuery(query);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int getRatingCount(int rating_code, String start_time, String end_time, String curr_date){
        try {
            String query = "SELECT count(*) FROM rating WHERE rating_code = "+rating_code+" AND rating_timestamp >= '"
                    +curr_date+" "+start_time+":00:00' AND rating_timestamp < '"+curr_date+" "+end_time+":00:00'";
            rs = stm.executeQuery(query);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

}
