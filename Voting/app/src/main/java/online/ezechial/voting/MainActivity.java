package online.ezechial.voting;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Model newModel;
    private ReadAndWriteFiles rnf;
    public final static String MESSAGE_KEY ="online.ezechial.voting.url";

    public void setVisibility(int viewState){
        findViewById(R.id.frame_Layout_neutral).setVisibility(viewState);
        findViewById(R.id.frame_Layout_smile).setVisibility(viewState);
        findViewById(R.id.frame_Layout_sad).setVisibility(viewState);
    }

    public void delayedSetVisible(int time){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setVisibility(View.VISIBLE);
            }
        }, time);
    }

    public void setShown(){
        setVisibility(View.INVISIBLE);
        delayedSetVisible(5000);
    }

    public void resetConnection(){
        finish();
        startActivity(new Intent(MainActivity.this, InsertServerLocation.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setVisibility(View.INVISIBLE);

        newModel = new Model();
        Intent newIntent = getIntent();
        newModel.setServerLocation(newIntent.getStringExtra(MESSAGE_KEY));
        newModel.Run();

        if (!newModel.getConnection()){
            resetConnection();
        }else{
            setVisibility(View.VISIBLE);
        }
        getSupportActionBar().hide();
    }

    public void smile(View view) {
        Toast.makeText(this,("Satisfied"),Toast.LENGTH_SHORT).show();
        if (!newModel.insertSmile()) resetConnection();
        setShown();
    }

    public void neutral(View view) {
        Toast.makeText(this,("Neutral"),Toast.LENGTH_SHORT).show();
        if (!newModel.insertNeutral()) resetConnection();
        setShown();
    }

    public void dissatisfied(View view) {
        Toast.makeText(this,("Dissatisfied"),Toast.LENGTH_SHORT).show();
        if (!newModel.insertSad()) resetConnection();
        setShown();
    }
}
