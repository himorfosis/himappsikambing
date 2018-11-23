package com.dinaham.sikarbing;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by him on 5/14/2018.
 */

public class DiagnosaAdapterHasil extends ArrayAdapter<DiagnosaHasilClassData> {

    private Context context;
    private List<DiagnosaHasilClassData> list;
    Database db;

    public DiagnosaAdapterHasil (Context context, List<DiagnosaHasilClassData> list) {

        super(context,R.layout.hasilrowlist, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public long getItemId ( int position) {
        return position;
    }

    @Override
    public View getView (int position, View view, ViewGroup parent) {

        View v = view;
        if ( v  == null) {

            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.hasilrowlist, null);
        }

        DiagnosaHasilClassData p = list.get(position);

        db = new Database(getContext());

        if (p != null) {

            TextView nilai = v.findViewById(R.id.nilai);
            TextView penyakit = v.findViewById(R.id.penyakit);

            Log.e("penyakit hasil", " " + p.getHasilPenyakit());
            Log.e("nilai hasil", " " + p.getHasilPenyakit());

            nilai.setText(p.getHasilNilai() + " %");
            penyakit.setText(p.getHasilPenyakit());





        }

        return v;
    }

}
