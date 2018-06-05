package online.ezechial.voting;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReadAndWriteFiles {
    private String filename ;
    private Context context ;
    private OutputStreamWriter outputStreamWriter;
    private InputStream inputStream;

    public ReadAndWriteFiles(Context context) {
        filename = "serverLocation.txt";
        this.context = context;
        File file = new File(context.getFilesDir(), filename);
    }

    public void writeToFile(String data) {
        try {
            outputStreamWriter = new OutputStreamWriter(context.openFileOutput(filename, Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
    public String readFromFile() {
        String ret = "";
        try {
            inputStream = context.openFileInput(filename);
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }
                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
        return ret;
    }

}

// this code are taken from "https://stackoverflow.com/questions/14376807/how-to-read-write-string-from-a-file-in-android"
