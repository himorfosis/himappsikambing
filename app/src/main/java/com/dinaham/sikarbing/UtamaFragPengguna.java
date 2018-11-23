package com.dinaham.sikarbing;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by him on 4/25/2018.
 */

public class UtamaFragPengguna extends Fragment {

    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;
    TextView text6;
    TextView text7;
    TextView text8;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return inflater.inflate(R.layout.utamafragpengguna, container, false);
    }

    public void onViewCreated(final View view, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onViewCreated(view, savedInstanceState);
        getActivity().invalidateOptionsMenu();

//        text1 = (TextView) view.findViewById(R.id.text1);
//        text2 = (TextView) view.findViewById(R.id.text2);
//        text3 = (TextView) view.findViewById(R.id.text3);
//        text4 = (TextView) view.findViewById(R.id.text4);
//        text5 = (TextView) view.findViewById(R.id.text5);
//        text6 = (TextView) view.findViewById(R.id.text6);
//        text7 = (TextView) view.findViewById(R.id.text7);
//        text8 = (TextView) view.findViewById(R.id.text8);
//
//        text1.setText("Aplikasi ini dibuat untuk persyaratan");
//        text2.setText("memperoleh gelar Sarjana Komputer");
//        text3.setText("di Jurusan Informatika Universitas Amikom");
//        text4.setText("Yogyakarta.\n");
//        text5.setText("Nama Aplikasi : SiKambing");
//        text6.setText("Pembuat : Dina Hamidah K");
//        text7.setText("Pembimbing : Kusnawi, S.kom, M.Eng.");
//        text8.setText("Pakar Kambing : Drh Andreas Widanarto");

    }

}
