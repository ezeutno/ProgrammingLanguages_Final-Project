package online.ezechial.voting;

import android.os.StrictMode;
import android.util.Log;
import java.sql.*;

public class DB {
    private Connection conn;
    private Statement stm;
//    private ResultSet rs;
//    private ResultSetMetaData rsmd;
    private String url = "jdbc:mysql://10.66.171.7/pl_finalproject";
    private String username = "ezechial";
    private String password = "";
    private String query = "";

    public boolean connectDB(){
        // to permit internet connection
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            return true;
        }catch(SQLException e){
            Log.i("info SQL","Error Message : "+e.getMessage());
            Log.i("info SQL State","Error Message : "+e.getSQLState());
            Log.i("info SQL Code","Error Message : "+e.getErrorCode());
        } catch (ClassNotFoundException e) {
            Log.i("info Class","Error Message : "+e.getMessage());
        } catch(Exception e){
            Log.i("exception","Error Message : "+e.getMessage());
        }
        return false;
    }

    public void insertData(int code){
        try{
            query = "INSERT INTO rating (rating_code) VALUES ("+code+")";
            stm.execute(query);
        }catch(Exception e){
            Log.i("info","Error Message : "+e.getMessage());
        }
    }

}
