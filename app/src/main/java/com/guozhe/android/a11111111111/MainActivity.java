package com.guozhe.android.a11111111111;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    final int LIST=1;
    final int CUSTOM=2;
    final int GRID=3;
    final int RECYCLE=4;
    String items[]={"선택하세요","listActivity","CustomActivity","GridActivity","RecycleActivity"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=(Spinner)findViewById(R.id.spinnerView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position){
                    case LIST:
                        intent=new Intent(MainActivity.this,ListActivity.class);
                        startActivity(intent);
                        break;
                    case CUSTOM:
                        intent=new Intent(MainActivity.this,CustomActivity.class);
                        startActivity(intent);
                        break;
                    case GRID:
                        intent=new Intent(MainActivity.this,GridActivity.class);
                        startActivity(intent);
                        break;
                    case RECYCLE:
                        intent=new Intent(MainActivity.this,RecycleActivity.class);
                        startActivity(intent);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
