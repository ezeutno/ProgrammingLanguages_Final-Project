package online.ezechial.voting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Model newModel = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!newModel.getConnection()) {
            finish();
        }else{
            getSupportActionBar().hide();
        }
    }

    public void smile(View view) {
        Toast.makeText(this,("Satisfied"),Toast.LENGTH_SHORT).show();
        newModel.insertSmile();
    }

    public void neutral(View view) {
        Toast.makeText(this,("Neutral"),Toast.LENGTH_SHORT).show();
        newModel.insertNeutral();
    }

    public void dissatisfied(View view) {
        Toast.makeText(this,("Dissatisfied"),Toast.LENGTH_SHORT).show();
        newModel.insertSad();
    }
}
