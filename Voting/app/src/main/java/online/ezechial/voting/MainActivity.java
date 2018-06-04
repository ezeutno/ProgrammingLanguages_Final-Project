package online.ezechial.voting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DB newDB = new DB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        Boolean data = newDB.connectDB();
        if (!data){
            Toast.makeText(this,("NOT CONNECTED"),Toast.LENGTH_SHORT).show();
        }
        setContentView(R.layout.activity_main);
    }

    public void smile(View view) {
        Toast.makeText(this,("Satisfied"),Toast.LENGTH_SHORT).show();
        newDB.insertData(1);
    }

    public void neutral(View view) {
        Toast.makeText(this,("Neutral"),Toast.LENGTH_SHORT).show();
        newDB.insertData(2);
    }

    public void dissatisfied(View view) {
        Toast.makeText(this,("Dissatisfied"),Toast.LENGTH_SHORT).show();
        newDB.insertData(3);
    }
}
