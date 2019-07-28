package orbital.milestone2;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Registration extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private EditText cpassword;
    private Button RegisterNow;
    private Button BackToHome;
    ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        cpassword = (EditText) findViewById(R.id.cpassword);
        RegisterNow = (Button) findViewById(R.id.btnreg2);
        BackToHome = (Button) findViewById(R.id.btnbacktohome);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        firebaseAuth = FirebaseAuth.getInstance();



        RegisterNow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String s1 = email.getText().toString();
                String s2 = password.getText().toString();
                String s3 = cpassword.getText().toString();

                progressBar.setVisibility(View.VISIBLE);

                if(s2.equals(s3)) {
                    firebaseAuth.createUserWithEmailAndPassword(s1, s2)
                            .addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                                    } else {

                                        if(task.getException() instanceof FirebaseAuthUserCollisionException) {
                                            Toast.makeText(getApplicationContext(), "You are already registered", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            });
                } else {
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });

        BackToHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Registration.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
