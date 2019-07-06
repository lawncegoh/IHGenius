package orbital.milestone2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

public class Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        Intent intent = new Intent(Information.this, Homepage.class);
                        startActivity(intent);
                        break;

                    case R.id.navigation_information:
                        Intent intent1 = new Intent(Information.this, Information.class);
                        startActivity(intent1);
                        break;

                    case R.id.navigation_setting:
                        Intent intent2 = new Intent(Information.this, Setting.class);
                        startActivity(intent2);
                        break;
                }

                return false;
            }
        });
    }

}
