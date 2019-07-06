package orbital.milestone2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Pref1 extends AppCompatActivity {
    private TextView mTextMessage;
    private Button next;
    private EditText preferredName;
    private EditText email;
    private EditText matric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref1);
        mTextMessage = findViewById(R.id.message);
        preferredName = findViewById(R.id.preferredname);
        email = findViewById(R.id.email2);
        matric = findViewById(R.id.matric);
        next = findViewById(R.id.homenext);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Pref1.this, Homepage.class);
                startActivity(intent);
            }
        });
    }

}
