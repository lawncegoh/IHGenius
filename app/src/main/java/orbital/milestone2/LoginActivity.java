package orbital.milestone2;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText Password;
    private Button Login;
    private TextView Question;
    private Button RegisterNow;
    private FirebaseAuth mAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        checkLoggedIn();

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        Password = findViewById(R.id.cpassword);
        Question =  findViewById(R.id.question);
        Login =  findViewById(R.id.btnsignin);
        RegisterNow = findViewById(R.id.btnbacktohome);
        progressBar = findViewById(R.id.progressbar);
        mAuth = FirebaseAuth.getInstance();

        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String user = email.getText().toString();
                String pass = Password.getText().toString();

                progressBar.setVisibility(View.VISIBLE);

                if (user.equals("admin")) {
                    System.out.println("moving");
                    Intent intent1 = new Intent(LoginActivity.this, AdminHome.class);
                    startActivity(intent1);
                } else {

                    mAuth.signInWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent;
                                intent = new Intent(LoginActivity.this, Pref1.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        RegisterNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(LoginActivity.this, Registration.class);
                startActivity(intent);
            }
        });
    }

    private void checkLoggedIn() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            Intent i = new Intent(LoginActivity.this, Homepage.class);
            startActivity(i);
        }
    }

}


