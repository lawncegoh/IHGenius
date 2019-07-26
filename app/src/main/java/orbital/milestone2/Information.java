package orbital.milestone2;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Information extends AppCompatActivity {

    private Button Ranks;
    private Button Scores;
    private Button Gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        Ranks = (Button) findViewById(R.id.rankings);
        Scores = (Button) findViewById(R.id.score);
        Gallery = (Button) findViewById(R.id.photobtn);
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

        Ranks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Information.this, Rankings.class);
                startActivity(intent3);
            }
        });

        Scores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(Information.this, RecyclerActivity.class);
                startActivity(intent4);
            }
        });

        Gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagesActivity();
            }
        });

    }

    private void openImagesActivity() {
        Intent intent = new Intent(this, ImagesActivity.class);
        startActivity(intent);
    }


}
