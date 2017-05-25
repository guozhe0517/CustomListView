package com.guozhe.android.a11111111111;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class DetaiActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detai);
        textView=(TextView)findViewById(R.id.textView2);
        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String result = "",result1="";

        if(bundle != null){

            result = bundle.getString(ListActivity.DATA_KEY);
            result1= bundle.getString(CustomActivity.DATA_KEY);
        }
           textView.setText(result);
//            textView.setText(result1);

        findViewById(R.id.backSpace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
