package orbital.milestone2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UpdateScoreActivity extends AppCompatActivity {

    FloatingActionButton add;
    DatabaseReference fireDb;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatescore);

        fireDb = FirebaseDatabase.getInstance().getReference("events");

        add = findViewById(R.id.fab_add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final EditText taskEditText = new EditText(UpdateScoreActivity.this);
                    AlertDialog dialog = new AlertDialog.Builder(UpdateScoreActivity.this)
                            .setTitle("Add a new event")
                            .setMessage("What do you want to do next?")
                            .setView(taskEditText)
                            .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String task = String.valueOf(taskEditText.getText());
                                    fireDb.push().setValue(task);
                                    System.out.println("created new event: " + task);
                                }
                            })
                            .setNegativeButton("Cancel", null)
                            .create();
                    dialog.show();
                    mAdapter.notifyDataSetChanged();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }
}