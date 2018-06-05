package online.ezechial.voting;

import android.os.StrictMode;
import android.util.Log;

import java.sql.*;

public class DB {
    private Connection conn;
    private Statement stm;
//    private ResultSet rs;
//    private ResultSetMetaData rsmd;
    private String url ;
    private String username = "ezechial";
    private String password = "";
    private String query = "";

    public void setServerLocation(String Location){
        url = "jdbc:mysql://"+Location+"/pl_finalproject";
        Log.i("INFO DB",url);
    }

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
        Log.i("URL RES","URL : "+url);
        return false;
    }

    public boolean insertData(int code){
        try{
            query = "INSERT INTO rating (rating_code) VALUES ("+code+")";
            stm.execute(query);
            return true;
        }catch(Exception e){
            Log.i("info","Error Message : "+e.getMessage());
            return false;
        }
    }

}
