package orbital.milestone2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    DatabaseHelper db;
    private EditText ID;
    private EditText Password;
    private EditText cpassword;
    private Button RegisterNow;
    private Button BackToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        db = new DatabaseHelper(this);
        ID = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        cpassword = (EditText) findViewById(R.id.cpassword);
        RegisterNow = (Button) findViewById(R.id.btnreg2);
        BackToHome = (Button) findViewById(R.id.btnbacktohome);

        RegisterNow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String s1 = ID.getText().toString();
                String s2 = Password.getText().toString();
                String s3 = cpassword.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (s2.equals(s3)) {
                        Boolean checkUser = db.checkUser(s1);
                        if (checkUser == true) {
                            Boolean insert = db.insert(s1, s2);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "An error has occurred", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "User Already Exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        BackToHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Registration.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
