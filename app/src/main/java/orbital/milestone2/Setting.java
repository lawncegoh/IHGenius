package orbital.milestone2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Setting extends AppCompatActivity {

    SwitchCompat switch_1, switch_2;

    boolean stateSwitch1, stateSwitch2;
    private FirebaseAuth mAuth;
    private Button signOut;
    private View fadeOut;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mAuth = FirebaseAuth.getInstance();

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        Intent intent = new Intent(Setting.this, Homepage.class);
                        startActivity(intent);
                        break;

                    case R.id.navigation_information:
                        Intent intent1 = new Intent(Setting.this, Information.class);
                        startActivity(intent1);
                        break;

                    case R.id.navigation_setting:
                        Intent intent2 = new Intent(Setting.this, Setting.class);
                        startActivity(intent2);
                        break;
                }

                return false;
            }
        });

        //switches

        prefs = getSharedPreferences("PREFS", 0);
        stateSwitch1 = prefs.getBoolean("switch1", false);
        stateSwitch1 = prefs.getBoolean("switch2", false);

        switch_1 = findViewById(R.id.switch_1);
        switch_2 = findViewById(R.id.switch_2);

        switch_1.setChecked(stateSwitch1);
        switch_2.setChecked(stateSwitch2);

        switch_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSwitch1 = !stateSwitch1;
                switch_1.setChecked(stateSwitch1);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("switch1", stateSwitch1);
                editor.apply();
            }
        });

        switch_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateSwitch2 = !stateSwitch2;
                switch_2.setChecked(stateSwitch2);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("switch2", stateSwitch2);
                editor.apply();
            }
        });

        signOut = findViewById(R.id.btnsignout);

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut();
            }
        });

        fadeOut = findViewById(R.id.fadeBackground);


    }

    private void logOut () {
        mAuth.signOut();
        Intent i = new Intent(Setting.this, LoginActivity.class);
        startActivity(i);
    }

}
