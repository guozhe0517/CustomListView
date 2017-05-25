package com.guozhe.android.a11111111111;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomActivity extends AppCompatActivity {
    ListView listView;
    public  static final String DATA_KEY="position";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);


        ArrayList<Data> datas = Loader.getData(this);
        CustomAdapter adapter = new CustomAdapter(datas, this);
        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(CustomActivity.this,DetaiActivity.class);
                intent.putExtra(DATA_KEY,position);
                startActivity(intent);
            }
        });


    }
}

class CustomAdapter extends BaseAdapter {
    ArrayList<Data> datas;
    LayoutInflater inflater;

    public CustomAdapter(ArrayList<Data> datas, Context context) {
        this.datas = datas;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_custom_list, null);
            holder = new Holder();
            holder.text1 = (TextView) convertView.findViewById(R.id.text1);
            holder.text2 = (TextView) convertView.findViewById(R.id.text2);
            holder.imageView=(ImageView)convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        Data data = datas.get(position);
        holder.text1.setText(data.text1+"");
        holder.text2.setText(data.text2);
        holder.imageView.setImageResource(data.resId);


        return convertView;
    }

    class Holder {
        TextView text1;
        TextView text2;
        ImageView imageView;
    }
}


class Data {
    public int text1;
    public String text2;
    public String image;
    public int resId;
    public void setImage(String str,Context context){
        image = str;
        resId=context.getResources().getIdentifier(image,"mipmap",context.getPackageName());

    }

}

class Loader {
    public static ArrayList<Data> getData(Context context) {
        ArrayList<Data> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            Data data = new Data();
            data.text1 = i;
            data.text2 = "image";
            data.setImage("image"+i,context);
            result.add(data);


        }

        return result;
    }
}
