package com.example.beriid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String namayayasan[] = {"Yayasan Baitunnisa", "Yayasan Sahabat Yatim Indonesia", "Yayasan Panti Wreda ",
    "Yayasan Perkasa", "Yayasan Nurul Hidayah"};
    String tipeyayasan[] = {"Panti Asuhan","Panti Asuhan","Panti Jompo","Panti Asuhan","Panti Asuhan" };
    int yimages[] = {R.drawable.yayasan1, R.drawable.yayasan2, R.drawable.yayasan3, R.drawable.yayasan4, R.drawable.yayasan5};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);


        MyAdapter adapter = new MyAdapter(this, namayayasan, tipeyayasan, yimages);
        listView.setAdapter(adapter);

    }

    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        String namayayasan[];
        String tipeyayasan[];
        int yimages[];

        MyAdapter (Context c, String namayayasan[],String tipeyayasan[], int yimages[] ){
            super(c, R.layout.listviewrow, R.id.yayasantext, namayayasan);
            this.context = c;
            this.namayayasan = namayayasan;
            this.tipeyayasan = tipeyayasan;
            this.yimages = yimages;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.listviewrow, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView mynamayayasan = row.findViewById(R.id.yayasantext);
            TextView mytipeyayasan = row.findViewById(R.id.tipeyayasantext);

            // now set our resources on views
            images.setImageResource(yimages[position]);
            mynamayayasan.setText(namayayasan[position]);
            mytipeyayasan.setText(tipeyayasan[position]);




            return row;
        }

    }


}