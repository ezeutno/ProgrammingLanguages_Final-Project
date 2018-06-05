package online.ezechial.voting;

import android.os.Handler;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Ezech on 6/5/2018.
 */

public class ServerInput implements Runnable {

    private Socket newSocket;
    private ServerSocket newSS;
    private InputStreamReader newISR;
    private BufferedReader newBR;
    private String message = "false";

    @Override
    public void run() {
        try{
            newSS = new ServerSocket(8000);
            while(true){
                newSS.accept();
                newISR = new InputStreamReader(newSocket.getInputStream());
                newBR = new BufferedReader(newISR);
                message = newBR.readLine();
            }
        }catch (IOException e){
            Log.i("Server Error : ",e.getMessage());
        };
    }

    public boolean getCurrentCond(){
      if (message.equalsIgnoreCase("true")){
          message = "false";
          return true;
      }else{
          return false;
      }
    };


}
