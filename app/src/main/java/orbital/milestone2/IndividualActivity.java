package orbital.milestone2;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class IndividualActivity extends AppCompatActivity {

    private static final String TAG = "IndividualActivitiy";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_individual);
        Log.d(TAG, "onCreate: started.");
    }
}
