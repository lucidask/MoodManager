package com.example.moodmanager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class UpdateHumour extends AppCompatActivity {
    TextView month ;
    TextView unknow;
    TextView angry;
    TextView frowning;
    TextView neutral;
    TextView slightly;
    TextView grinning;
    String pos=null;
    TextView percentangry;
    TextView percentfrowning;
    TextView percentneutral;
    TextView percentslightly;
    TextView percentgrinning;
    Double totalhumour=0.00;
    PieChart pieChart;
    private int[]humourvalue=new int[5];
    LineChart lineChart;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_humour);
        month=(TextView)findViewById(R.id.humourmonth);
        unknow=(TextView)findViewById(R.id.amountunknow);
        angry=(TextView)findViewById(R.id.amountangry);
        frowning=(TextView)findViewById(R.id.amountfrowning);
        neutral=(TextView)findViewById(R.id.amountneutral);
        slightly=(TextView)findViewById(R.id.amountslightly);
        grinning=(TextView)findViewById(R.id.amountgrinning);
        percentangry=(TextView)findViewById(R.id.percentangry);
        percentfrowning=(TextView)findViewById(R.id.percentfrownig);
        percentneutral=(TextView)findViewById(R.id.percentneutral);
        percentslightly=(TextView)findViewById(R.id.percentslightly);
        percentgrinning=(TextView)findViewById(R.id.percentgrinning);
        pieChart=(PieChart)findViewById(R.id.PieChart);
        lineChart=(LineChart)findViewById(R.id.LineChart);
        humourview();
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void humourview(){
        for (int i=0;i<DAO.HumourTab.size();i++){
            if(DAO.HumourTab.get(i).isClicked()){
                unknow.setText(""+DAO.HumourTab.get(i).getUnknow());
                angry.setText(""+DAO.HumourTab.get(i).getAngry());
                frowning.setText(""+DAO.HumourTab.get(i).getFrowning());
                neutral.setText(""+DAO.HumourTab.get(i).getNeutral());
                slightly.setText(""+DAO.HumourTab.get(i).getSligthlysmiling());
                grinning.setText(""+DAO.HumourTab.get(i).getGrinningsmiling());
                month.setText(DAO.HumourTab.get(i).getMonth()+" "+DAO.HumourTab.get(i).getYear());

                totalhumour=Double.parseDouble(String.valueOf(DAO.HumourTab.get(i).getAngry()+DAO.HumourTab.get(i).getFrowning()+
                        DAO.HumourTab.get(i).getNeutral()+DAO.HumourTab.get(i).getSligthlysmiling()+
                        DAO.HumourTab.get(i).getGrinningsmiling()));
                if(totalhumour>0){
                    percentangry.setText(""+(int)(Double.parseDouble(String.valueOf(DAO.HumourTab.get(i).getAngry()))/totalhumour*100.00)+"%");
                    percentfrowning.setText(""+(int)(Double.parseDouble(String.valueOf(DAO.HumourTab.get(i).getFrowning()))/totalhumour*100.00)+"%");
                    percentneutral.setText(""+(int)(Double.parseDouble(String.valueOf(DAO.HumourTab.get(i).getNeutral()))/totalhumour*100.00)+"%");
                    percentslightly.setText(""+(int)(Double.parseDouble(String.valueOf(DAO.HumourTab.get(i).getSligthlysmiling()))/totalhumour*100.00)+"%");
                    percentgrinning.setText(""+(int)(Double.parseDouble(String.valueOf(DAO.HumourTab.get(i).getGrinningsmiling()))/totalhumour*100.00)+"%");
                }
                pieChart.setHoleRadius(0);
                pieChart.setTransparentCircleAlpha(0);
                pieChart.setUsePercentValues(false);
                lineChart.getDescription().setEnabled(false);
                addDataSet();
                pos= String.valueOf(i);
                break;
            }
        }
    }

    private void addDataSet() {
        ArrayList<PieEntry> HumourEntry= new ArrayList<>();
        ArrayList<Entry> HumourEntryLine= new ArrayList<>();
        for (int i=0;i<DAO.HumourTab.size();i++){
            if(DAO.HumourTab.get(i).isClicked()){
                humourvalue[0]=DAO.HumourTab.get(i).getAngry();
                humourvalue[1]=DAO.HumourTab.get(i).getFrowning();
                humourvalue[2]=DAO.HumourTab.get(i).getNeutral();
                humourvalue[3]=DAO.HumourTab.get(i).getSligthlysmiling();
                humourvalue[4]=DAO.HumourTab.get(i).getGrinningsmiling();
                break;
            }
        }
        for (int i=0;i<humourvalue.length;i++){
            HumourEntry.add(new PieEntry(humourvalue[i],i));
        }

        for (int i=0;i<humourvalue.length;i++){
            HumourEntryLine.add(new Entry(humourvalue[i],i));
        }
        //PieChar*******************************************************
        PieDataSet pieDataSet= new PieDataSet(HumourEntry,"");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(10);

        ArrayList<Integer> colors=new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.MAGENTA);
        colors.add(Color.GREEN);
        colors.add(Color.CYAN);
        colors.add(Color.YELLOW);

        Legend legend=pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setFormSize(10);
        legend.setEnabled(false);

        pieDataSet.setColors(colors);
        PieData pieData=new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

        //LineChar*******************************************************
        LineDataSet lineDataSet=new LineDataSet(HumourEntryLine,"");
        lineDataSet.setColor(Color.RED);
        lineDataSet.setLineWidth(3);
        ArrayList<ILineDataSet> iLineDataSets=new ArrayList<>();
        iLineDataSets.add(lineDataSet);
        LineData lineData=new LineData(iLineDataSets);
        Legend legendLine=lineChart.getLegend();
        legendLine.setEnabled(false);
        lineChart.setData(lineData);
        lineChart.invalidate();

    }

    public void backarrow(View view) {
        if(pos!=null){
            DAO.HumourTab.get(Integer.parseInt(pos)).setClicked(false);
        }
        Intent Home= new Intent(getApplicationContext(),MainActivity.class);
        startActivity(Home);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addunknowhumour(View view) {
        int tamp= Integer.parseInt(unknow.getText().toString());
        tamp++;
        unknow.setText(""+tamp);
        for (int i=0;i<DAO.HumourTab.size();i++){
            if(DAO.HumourTab.get(i).isClicked()){
                DAO.HumourTab.get(i).setUnknow(tamp);
                break;
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addangryhumour(View view) {
        int tamp= Integer.parseInt(angry.getText().toString());
        tamp++;
        angry.setText(""+tamp);
        for (int i=0;i<DAO.HumourTab.size();i++){
            if(DAO.HumourTab.get(i).isClicked()){
                DAO.HumourTab.get(i).setAngry(tamp);
                break;
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addfrowninghumour(View view) {
        int tamp= Integer.parseInt(frowning.getText().toString());
        tamp++;
        frowning.setText(""+tamp);
        for (int i=0;i<DAO.HumourTab.size();i++){
            if(DAO.HumourTab.get(i).isClicked()){
                DAO.HumourTab.get(i).setFrowning(tamp);
                break;
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addneutralhumour(View view) {
        int tamp= Integer.parseInt(neutral.getText().toString());
        tamp++;
        neutral.setText(""+tamp);
        for (int i=0;i<DAO.HumourTab.size();i++){
            if(DAO.HumourTab.get(i).isClicked()){
                DAO.HumourTab.get(i).setNeutral(tamp);
                break;
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addslightlyhumour(View view) {
        int tamp= Integer.parseInt(slightly.getText().toString());
        tamp++;
        slightly.setText(""+tamp);
        for (int i=0;i<DAO.HumourTab.size();i++){
            if(DAO.HumourTab.get(i).isClicked()){
                DAO.HumourTab.get(i).setSligthlysmiling(tamp);
                break;
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addgrinninghumour(View view) {
        int tamp= Integer.parseInt(grinning.getText().toString());
        tamp++;
        grinning.setText(""+tamp);
        for (int i=0;i<DAO.HumourTab.size();i++){
            if(DAO.HumourTab.get(i).isClicked()){
                DAO.HumourTab.get(i).setGrinningsmiling(tamp);
                break;
            }
        }
    }
}