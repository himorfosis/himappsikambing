package com.dinaham.sikarbing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by him on 4/25/2018.
 */

public class UtamaFragBeranda extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return inflater.inflate(R.layout.utamafragberanda, container, false);
    }

    public void onViewCreated(final View view, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onViewCreated(view, savedInstanceState);
        getActivity().invalidateOptionsMenu();

        final Button diagnosa = (Button)view.findViewById(R.id.diagnosa);
        final Button infopenyakit = (Button)view.findViewById(R.id.infopenyakit);
        final Button riwayat = (Button)view.findViewById(R.id.riwayat);
        Button keluar = (Button)view.findViewById(R.id.keluar);

        diagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Diagnosa.class);

                getActivity().startActivity(intent);
            }
        });

        infopenyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), InfoPenyakit.class);

                getActivity().startActivity(intent);
            }
        });

        riwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Riwayat.class);

                getActivity().startActivity(intent);
            }
        });

        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().finish();
                System.exit(0);
            }
        });

    }
}
