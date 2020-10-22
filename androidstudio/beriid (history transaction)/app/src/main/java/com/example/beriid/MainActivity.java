package com.example.beriid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
//import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    String namaDonator[] = {"Donator A","Donator B","Donator C","Donator D","Donator E"};
    String namaYayasan[] = {"Yayasan A","Yayasan B","Yayasan C","Yayasan D","Yayasan E"};
    String sumbangan[] = {"Masker Kain (10 pcs)","Buku Pelajaran (20 pcs)","Masker Kain (30 pcs)","Buku Pelajaran (40 pcs)","Masker Kain (30 pcs)"};
    int fotoDonator[] = {};
    int fotoYayasan[] = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        MyAdapter donator = new MyAdapter(this, namaYayasan, sumbangan, fotoDonator);
        listView.setAdapter(donator);
    }

    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        String namaDonator[];
        String sumbangan[];
        int fotoDonator[];

        MyAdapter (Context c, String namaDonator[],String sumbangan[], int fotoDonator[] ){
            super(c, R.layout.listviewrow, R.id.nama, namaDonator);
            this.context = c;
            this.namaDonator = namaDonator;
            this.sumbangan = sumbangan;
            this.fotoDonator = fotoDonator;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.listviewrow, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myNamaDonator = row.findViewById(R.id.nama);
            TextView mySumabangan = row.findViewById(R.id.sumbangan);

            images.setImageResource(fotoDonator[position]);
            myNamaDonator.setText(namaDonator[position]);
            mySumabangan.setText(sumbangan[position]);

            return row;
        }
    }
}




