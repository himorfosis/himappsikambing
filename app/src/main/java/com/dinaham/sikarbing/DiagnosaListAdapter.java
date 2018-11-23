package com.dinaham.sikarbing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DiagnosaListAdapter  extends ArrayAdapter<ClassDataGejala> {

    ArrayList<ClassDataGejala> daftargejala = new ArrayList<>();
//    private Context context;
    private List<ClassDataGejala> list;
//    SharedPref sharedPref;

    public DiagnosaListAdapter(Context context, int textViewResourceId, ArrayList<ClassDataGejala> list) {

        super(context, textViewResourceId, list );
//        this.context = context;
        daftargejala = list;
//        SharedPref sharedPref = new SharedPref();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View view = super.getView(position, convertView, parent);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(android.R.layout.simple_list_item_multiple_choice, null);

        TextView isigejala = (TextView) view.findViewById(android.R.id.text1);

        isigejala.setText(daftargejala.get(position).getGejala());
        isigejala.setTextSize(17);


        return view;
    }
}
