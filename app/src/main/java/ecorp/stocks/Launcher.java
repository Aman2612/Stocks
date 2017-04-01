package ecorp.stocks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Launcher extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        editText = (EditText) findViewById(R.id.edit);
        search = (Button) findViewById(R.id.searchButton);
        search.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        
    }
}
