package com.dinaham.sikarbing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by him on 5/5/2018.
 */

public class InfoPenyakitListAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] nomorpenyakit;
    private final String[] namapenyakit;

    public InfoPenyakitListAdapter (Context context, String[] nomor, String[] namapenyakit) {
        super(context, R.layout.listinfopenyakit, namapenyakit);


        this.context=context;
        this.nomorpenyakit = nomor;
        this.namapenyakit = namapenyakit;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater= LayoutInflater.from(getContext());
        View rowView = inflater.inflate(R.layout.rowinfopenyakit, null,true);

        TextView nomor = (TextView) rowView.findViewById(R.id.nomor);
        TextView namagejala = (TextView) rowView.findViewById(R.id.namagejala);



        nomor.setText(nomorpenyakit[position]);
        namagejala.setText(namapenyakit[position]);

        return rowView;

    };
}
