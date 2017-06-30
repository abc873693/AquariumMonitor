package com.example.jp6y7.aquariummonitor;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class CurveActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curve);
        LineChart chart = (LineChart) findViewById(R.id.chart);

        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(1, 100));
        entries.add(new Entry(2, 54));
        entries.add(new Entry(4, 85));
        List<Entry> entries_B = new ArrayList<Entry>();
        entries_B.add(new Entry(1, 44));
        entries_B.add(new Entry(2, 88));
        entries_B.add(new Entry(4, 5));

        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
        dataSet.setColor(ContextCompat.getColor(this,R.color.red_300));
        dataSet.setValueTextColor(ContextCompat.getColor(this,R.color.red_300)); // styling, ...

        LineDataSet dataSet_B = new LineDataSet(entries_B, "Label B"); // add entries to dataset

        List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(dataSet);
        dataSets.add(dataSet_B);

        chart.setData(new LineData(dataSets));
        chart.invalidate(); // refresh

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CurveActivity.this,MainActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }
        });
    }
}
