package com.dinaham.sikarbing;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentContainer;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by him on 4/27/2018.
 */

public class DiagnosaFragHome extends Fragment {

    Fragment fragment;

    Bundle bundle = new Bundle();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        return inflater.inflate(R.layout.diagnosafraghome, container, false);
}

    public void onViewCreated(final View view, Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        super.onViewCreated(view, savedInstanceState);
        getActivity().invalidateOptionsMenu();

        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();

        final Button kembali = (Button) actionBar.getCustomView().findViewById(R.id.kembali);
        kembali.setVisibility(View.VISIBLE);

        Button kepala = (Button) view.findViewById(R.id.kepala);
        Button badan = (Button) view.findViewById(R.id.badan);
        Button kaki = (Button) view.findViewById(R.id.kaki);
        Button ambing = (Button) view.findViewById(R.id.ambing);
        Button reproduksi = (Button) view.findViewById(R.id.reproduksi);
        Button lainlain = (Button) view.findViewById(R.id.lainlain);

        kepala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundle.putString("data", "kepala");

                fragment = new DiagnosaPilihData();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });

        badan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundle.putString("data", "badan");

                fragment = new DiagnosaPilihData();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });

        kaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundle.putString("data", "kaki");

                fragment = new DiagnosaPilihData();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });

        ambing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundle.putString("data", "ambing");

                fragment = new DiagnosaPilihData();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });

        reproduksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundle.putString("data", "reproduksi");

                fragment = new DiagnosaPilihData();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });

        lainlain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundle.putString("data", "lainlain");

                fragment = new DiagnosaPilihData();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().finish();
            }
        });
}

}
