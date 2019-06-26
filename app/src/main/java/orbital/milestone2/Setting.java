package orbital.milestone2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        BottomNavigationView navView = findViewById(R.id.nav_view);

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

                    case R.id.navigation_settings:
                        Intent intent2 = new Intent(Setting.this, Setting.class);
                        startActivity(intent2);
                        break;
                }

                return false;
            }
        });
    }

}
