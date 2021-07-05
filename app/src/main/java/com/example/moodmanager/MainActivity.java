package com.example.moodmanager;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listtoview;
    TextView amout;
    static ArrayList<Humour> humourmonthyear;
    ArrayAdapter<Humour> TabListAdapter;
    boolean verif=false;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listtoview=(ListView)findViewById(R.id.listcalendar);
        amout=(TextView)findViewById(R.id.amount);
        getallHumour();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void getallHumour(){
        humourmonthyear = new ArrayList<>();
        if(DAO.HumourTab.size()>0){
            if(DAO.HumourTab.size()>5) {
                for (int i=DAO.HumourTab.size()-1 ; i <DAO.HumourTab.size()-6 ; i--) {
                    humourmonthyear.add(DAO.HumourTab.get(i));
                }
            }
            else {
                for (int i = 0; i <DAO.HumourTab.size(); i++) {
                    humourmonthyear.add(DAO.HumourTab.get(i));
                }
            }
            amout.setText("Last "+humourmonthyear.size()+" Month(s)");
            TabListAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, humourmonthyear);
            listtoview.setAdapter(TabListAdapter);
            listtoview.setOnItemClickListener(this);
        }
        else{
            amout.setText("Empty");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TabListAdapter.getItem(position).setClicked(true);
        Intent UpdateHumour= new Intent(getApplicationContext(),UpdateHumour.class);
        startActivity(UpdateHumour);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void launchHumourPage(View view) {
        Calendar calendar=Calendar.getInstance();
        if(DAO.HumourTab.size()<=0){
            DAO.addHumour(new Humour(Month.of(calendar.get(Calendar.MONTH)+1),Year.now(),0,0,
                    0,0,0,0,false));
            Intent Humour= new Intent(getApplicationContext(),ManageHumour.class);
            startActivity(Humour);
        }
        else {
            for (int i=0;i<DAO.HumourTab.size();i++){
                if (DAO.HumourTab.get(i).getMonth().equals(Month.of(calendar.get(Calendar.MONTH)+1)) &&
                        DAO.HumourTab.get(i).getYear().equals(Year.now())) {
                    verif=true;
                    break;
                }
            }
            if(verif){
                Toast.makeText(MainActivity.this,"Already added for this month: "+Month.of(calendar.get(Calendar.MONTH)+1),
                        Toast.LENGTH_SHORT).show();
                verif=false;
            }
            else {
                DAO.addHumour(new Humour(Month.of(calendar.get(Calendar.MONTH)+1),Year.now(),0,0,0,
                        0,0,0,false));
                Intent Humour= new Intent(getApplicationContext(),ManageHumour.class);
                startActivity(Humour);
            }
        }
    }
}