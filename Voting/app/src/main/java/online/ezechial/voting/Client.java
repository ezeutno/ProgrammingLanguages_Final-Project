package online.ezechial.voting;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client implements Runnable{
    private Socket socket;
    private String loc;
    private InputStream IS;
    private DataInputStream input;
    private boolean data;

    public Client(String location){
        this.loc = location;
        this.socket = new Socket();
        this.data = false;
    }

    @Override
    public void run(){}

    public boolean getConnection(){
        return data;
    }

    public void connect(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try{
            this.socket.connect(new InetSocketAddress(loc, 8000), 10000);
            try{
                this.input = new DataInputStream(this.IS = this.socket.getInputStream());
                data = true;
            }catch(Exception ex){
                Log.i("I/O","Failed");
            }
        }catch(Exception e){
            Log.i("Check Client","Client failed to initialize" + e.getMessage());
        }
        data = false;
    }

    public boolean waitSignal(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try{
            return input.readBoolean();
        }catch(Exception e){
            Log.i("Boolean Data","ERROR");
        }
        Log.i("CHECK WAIT ","END");
        return false;
    }
}
