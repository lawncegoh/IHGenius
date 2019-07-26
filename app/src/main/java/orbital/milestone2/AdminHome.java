package orbital.milestone2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


    public class AdminHome extends AppCompatActivity {

        private Button uploader;
        private Button updater;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_adminhome);

            uploader = findViewById(R.id.btnToUpload);

            uploader.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(orbital.milestone2.AdminHome.this, UploadActivity.class);
                    startActivity(intent);
                }
            });

            updater = findViewById(R.id.btntoUpdate);

            updater.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AdminHome.this, UpdateScoreActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
