package com.dinaham.sikarbing;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by him on 5/13/2018.
 */

public class RiwayatListAdapter extends ArrayAdapter<RiwayatClassData> {

    private Context context;
    private List<RiwayatClassData> list;
    Database db;

    public RiwayatListAdapter (Context context, List<RiwayatClassData> list) {

        super(context,R.layout.riwayatrowlist, list);
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
            v = vi.inflate(R.layout.riwayatrowlist, null);
        }

        RiwayatClassData p = list.get(position);

        db = new Database(getContext());

        if (p != null) {

            TextView tanggal = v.findViewById(R.id.tanggal);
            TextView penyakit = v.findViewById(R.id.penyakit);

            tanggal.setText(p.getTanggal());
            penyakit.setText(p.getPenyakit());

            Log.e("penyakit get", " " + p.getPenyakit());
            Log.e("tanggal get", " " + p.getTanggal());



        }

        return v;
    }
}
