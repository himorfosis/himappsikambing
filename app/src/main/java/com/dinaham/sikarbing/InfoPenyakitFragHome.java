package com.dinaham.sikarbing;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class InfoPenyakitFragHome extends Fragment {

    Fragment fragment;

    Bundle bundle = new Bundle();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.infopenyakitfraghome, container, false);
    }

        public void onViewCreated ( final View view, Bundle savedInstanceState){

            setHasOptionsMenu(true);
            super.onViewCreated(view, savedInstanceState);
            getActivity().invalidateOptionsMenu();

            ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

            final Button kembali = (Button) actionBar.getCustomView().findViewById(R.id.kembali);
            kembali.setVisibility(View.VISIBLE);

            final LinearLayout scabies = view.findViewById(R.id.scabies);
            LinearLayout mastitis = view.findViewById(R.id.mastitis);
            LinearLayout pneumonia = view.findViewById(R.id.pneumonia);
            LinearLayout hipokalsemia = view.findViewById(R.id.hipokalsemia);
            LinearLayout pinkeye = view.findViewById(R.id.pinkeye);
            LinearLayout kembung = view.findViewById(R.id.kembung);
            LinearLayout cacingan = view.findViewById(R.id.cacingan);
            LinearLayout orf = view.findViewById(R.id.orf);
            LinearLayout antraks = view.findViewById(R.id.antraks);
            LinearLayout kukubusuk = view.findViewById(R.id.kukubusuk);
            LinearLayout kegugurangan = view.findViewById(R.id.keguguran);


            scabies.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    bundle.putString("data", "scabies");
                    fragment = new InfoPenyakitFragData();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
            });

            mastitis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    bundle.putString("data", "mastitis");
                    fragment = new InfoPenyakitFragData();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
            });

            pneumonia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    bundle.putString("data", "pneumonia");
                    fragment = new InfoPenyakitFragData();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
            });

            hipokalsemia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    bundle.putString("data", "hipokalsemia");
                    fragment = new InfoPenyakitFragData();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
            });

            pinkeye.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    bundle.putString("data", "pinkeye");
                    fragment = new InfoPenyakitFragData();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
            });

            kembung.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    bundle.putString("data", "kembung");
                    fragment = new InfoPenyakitFragData();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
            });

            cacingan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    bundle.putString("data", "cacingan");
                    fragment = new InfoPenyakitFragData();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
            });

            orf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    bundle.putString("data", "orf");
                    fragment = new InfoPenyakitFragData();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
            });

            antraks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    bundle.putString("data", "antraks");
                    fragment = new InfoPenyakitFragData();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
            });

            kukubusuk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    bundle.putString("data", "kukubusuk");
                    fragment = new InfoPenyakitFragData();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }
            });

            kegugurangan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    bundle.putString("data", "keguguran");
                    fragment = new InfoPenyakitFragData();
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
