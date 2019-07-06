package orbital.milestone2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Rankings extends AppCompatActivity {
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankings);

        barChart = (BarChart) findViewById(R.id.bargraph);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(44f,0));
        barEntries.add(new BarEntry(55f,1));
        barEntries.add(new BarEntry(80f,2));
        barEntries.add(new BarEntry(60f,3));
        barEntries.add(new BarEntry(100f,4));
        barEntries.add(new BarEntry(20f,5));
        BarDataSet barDataSet = new BarDataSet(barEntries, "Score");

        ArrayList<String> Halls = new ArrayList<>();

        Halls.add("Kent Ridge");
        Halls.add("Sheares");
        Halls.add("Temasek");
        Halls.add("PGP");
        Halls.add("Raffles");
        Halls.add("Eusoff");

        BarData theData = new BarData(barDataSet);
        barChart.setData(theData);
    }

}
