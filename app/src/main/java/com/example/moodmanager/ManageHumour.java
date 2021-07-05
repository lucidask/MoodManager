package com.example.moodmanager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Month;
import java.time.Year;
import java.util.Calendar;

public class ManageHumour extends AppCompatActivity {
    TextView month ;
    TextView unknow;
    TextView angry;
    TextView frowning;
    TextView neutral;
    TextView slightly;
    TextView grinning;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_humour);
        month=(TextView)findViewById(R.id.humourmonth);
        unknow=(TextView)findViewById(R.id.amountunknow);
        angry=(TextView)findViewById(R.id.amountangry);
        frowning=(TextView)findViewById(R.id.amountfrowning);
        neutral=(TextView)findViewById(R.id.amountneutral);
        slightly=(TextView)findViewById(R.id.amountslightly);
        grinning=(TextView)findViewById(R.id.amountgrinning);
        humourview();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    public void humourview(){
        Calendar cal=  Calendar.getInstance();
        month.setText(""+ Month.of(cal.get(Calendar.MONTH)+1)+" "+cal.get(Calendar.YEAR));
    }

    public void backarrow(View view) {
        Intent Home= new Intent(getApplicationContext(),MainActivity.class);
        startActivity(Home);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addunknowhumour(View view) {
        int tamp= Integer.parseInt(unknow.getText().toString());
        tamp++;
        unknow.setText(""+tamp);
        Calendar calendar=Calendar.getInstance();
        for (int i=0;i<DAO.HumourTab.size();i++){
            if(DAO.HumourTab.get(i).getMonth().equals(Month.of(calendar.get(Calendar.MONTH)+1)) &&
                    DAO.HumourTab.get(i).getYear().equals(Year.now())){
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
        Calendar calendar=Calendar.getInstance();
        for (int i=0;i<DAO.HumourTab.size();i++){
            if(DAO.HumourTab.get(i).getMonth().equals(Month.of(calendar.get(Calendar.MONTH)+1)) &&
                    DAO.HumourTab.get(i).getYear().equals(Year.now())){
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
        Calendar calendar=Calendar.getInstance();
        for (int i=0;i<DAO.HumourTab.size();i++){
            if(DAO.HumourTab.get(i).getMonth().equals(Month.of(calendar.get(Calendar.MONTH)+1)) &&
                    DAO.HumourTab.get(i).getYear().equals(Year.now())){
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
        Calendar calendar=Calendar.getInstance();
        for (int i=0;i<DAO.HumourTab.size();i++){
            if(DAO.HumourTab.get(i).getMonth().equals(Month.of(calendar.get(Calendar.MONTH)+1)) &&
                    DAO.HumourTab.get(i).getYear().equals(Year.now())){
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
        Calendar calendar=Calendar.getInstance();
        for (int i=0;i<DAO.HumourTab.size();i++){
            if(DAO.HumourTab.get(i).getMonth().equals(Month.of(calendar.get(Calendar.MONTH)+1)) &&
                    DAO.HumourTab.get(i).getYear().equals(Year.now())){
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
        Calendar calendar=Calendar.getInstance();
        for (int i=0;i<DAO.HumourTab.size();i++){
            if(DAO.HumourTab.get(i).getMonth().equals(Month.of(calendar.get(Calendar.MONTH)+1)) &&
                    DAO.HumourTab.get(i).getYear().equals(Year.now())){
                DAO.HumourTab.get(i).setGrinningsmiling(tamp);
                break;
            }
        }
    }
}