package orbital.milestone2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    private EditText ID;
    private EditText Password;
    private Button Login;
    private TextView Question;
    private Button RegisterNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        ID = (EditText)findViewById(R.id.username);
        Password = (EditText)findViewById(R.id.cpassword);
        Question = (TextView)findViewById(R.id.question);
        Login = (Button)findViewById(R.id.btnsignin);
        RegisterNow = (Button)findViewById(R.id.btnbacktohome);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = ID.getText().toString();
                String pass = Password.getText().toString();
                validate(user,pass);
            }
        });

        RegisterNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
            }
        });
    }

    private void validate(String username, String password) {
        if(username.equals("") || password.equals("")) {
            Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
        }
        Boolean checkies = db.checkReal(username, password);
        if(checkies==true) {
            Intent intent2;
            intent2 = new Intent(MainActivity.this, HomePage.class);
            startActivity(intent2);
        } else {
            Toast.makeText(getApplicationContext(), "Username or password is wrong", Toast.LENGTH_SHORT).show();
        }
    }

}


