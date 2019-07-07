package orbital.milestone2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;

import java.util.ArrayList;
import java.util.List;

public class Rankings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankings);

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);

        Cartesian cartesian = AnyChart.column();

        List<DataEntry> data = new ArrayList<>();
        data.add(new ValueDataEntry("KR", 100));
        data.add(new ValueDataEntry("SH", 99));
        data.add(new ValueDataEntry("EH", 10));
        data.add(new ValueDataEntry("TH", 85));
        data.add(new ValueDataEntry("PGP", 50));
        data.add(new ValueDataEntry("RH", 49));

        Column column = cartesian.column(data);

        column.tooltip()
                .titleFormat("Score:")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM);
                //.offsetX(0d)
                //.offsetY(5d);
                //.format("${%Value}{groupsSeparator: }");

        cartesian.animation(true);
        cartesian.title("IHG Standings as of 070719");

        cartesian.yScale().minimum(0d);

        //cartesian.yAxis(0).labels().format("${%Value}{groupsSeparator: }");

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);

        cartesian.xAxis(0).title("Hall");
        cartesian.yAxis(0).title("Total Points");

        anyChartView.setChart(cartesian);
    }
}