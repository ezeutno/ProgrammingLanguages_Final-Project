package online.ezechial.voting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertServerLocation extends AppCompatActivity {

    private EditText loc;
    private ReadAndWriteFiles rnf;
    public final static String MESSAGE_KEY ="online.ezechial.voting.url";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_server_location);
        rnf = new ReadAndWriteFiles(InsertServerLocation.this);
        loc = findViewById(R.id.locServer);
        loc.setText(rnf.readFromFile());
    }

    public void connectServer(View view) {
        String content = loc.getText().toString();
        rnf.writeToFile(content);
        Intent newIntent = new Intent(InsertServerLocation.this, MainActivity.class);
        newIntent.putExtra(MESSAGE_KEY,content);
        Toast.makeText(this,("Re-Connecting"),Toast.LENGTH_SHORT).show();
        finish();
        startActivity(newIntent);
    }
}
