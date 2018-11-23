package com.dinaham.sikarbing;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by him on 4/25/2018.
 */

public class UtamaFragBantuan extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return inflater.inflate(R.layout.utamafragbantuan, container, false);
    }

    public void onViewCreated(final View view, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onViewCreated(view, savedInstanceState);
        getActivity().invalidateOptionsMenu();

        LinearLayout Diagnosa = (LinearLayout)view.findViewById(R.id.diagnosabantuan);
        LinearLayout InfoPenyakit = (LinearLayout)view.findViewById(R.id.infopenyakitbantuan);
        LinearLayout Riwayat = (LinearLayout)view.findViewById(R.id.riwayatbantuan);


        Diagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(getActivity(), Bantuan.class);
//
//                intent.putExtra("key", "diagnosa");
//                startActivity(intent);

//                Bundle bundle = new Bundle();
//                bundle.putString("key", "diagnosa");

                Intent intent = new Intent(getContext(), Bantuan.class);
                intent.putExtra("key", "diagnosa");
//                intent.putExtra(bundle);
                getActivity().startActivity(intent);

            }
        });

        InfoPenyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getContext(), Bantuan.class);

                intent.putExtra("key", "infopenyakit");
                startActivity(intent);

            }
        });

        Riwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Bantuan.class);

                intent.putExtra("key", "riwayat");
                startActivity(intent);

            }
        });
    }
}
