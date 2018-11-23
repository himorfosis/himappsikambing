package com.dinaham.sikarbing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by him on 5/8/2018.
 */

public class DiagnosaFragHasil extends Fragment {

    String keynilai;
    String keypenyakit;
    String isitanggal;

    Fragment fragment;
    Database db;

    public static DecimalFormat fixhasil = new DecimalFormat("##.##");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.diagnosafraghasil, container, false);
    }

    public void onViewCreated(final View view, Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        super.onViewCreated(view, savedInstanceState);
        getActivity().invalidateOptionsMenu();
        savedInstanceState = getArguments();

        db = new Database(getContext());

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        final Button kembali = (Button) actionBar.getCustomView().findViewById(R.id.kembali);
        kembali.setVisibility(View.VISIBLE);

        final TextView nilai = (TextView) view.findViewById(R.id.nilai);
        final TextView penyakit = (TextView) view.findViewById(R.id.penyakit);
        Button detail = (Button) view.findViewById(R.id.detail);
        ListView list = (ListView) view.findViewById(R.id.listhasil);
        Button simpan = (Button) view.findViewById(R.id.simpan);

//        String test = Utilities.getValueName("hasildiagnosa", "text" , getContext());

        if (savedInstanceState == null) {

        } else {

            keynilai = savedInstanceState.getString("nilai");
            keypenyakit = savedInstanceState.getString("penyakit");

        }

        Log.e("nilai", ": " +keynilai);
        Log.e("penyakit", ": " +keypenyakit);

//        nilai.setText(fixhasil.format(keynilai) + " %");
        nilai.setText(keynilai + " %");
        penyakit.setText(keypenyakit);

        String data[] = null;
        db = new Database(getContext());

        final List<DiagnosaHasilClassData> dataList = db.getallhasil();
        data = new String[dataList.size()];

        int i = 0;

        for (DiagnosaHasilClassData b : dataList) {

            data[i] = b.getId_hasil()+ b.getHasilPenyakit() + b.getHasilNilai();

            i++;

//            Log.e("penyaktt", " " +b.getHasilPenyakit());
//            Log.e("nilai", " " +b.getHasilNilai());

        }

        final DiagnosaAdapterHasil adapter = new DiagnosaAdapterHasil(getContext(), dataList);
        list.setAdapter(adapter);

        Calendar c = Calendar.getInstance();

        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate1 = df2.format(c.getTime());
        String[] daysArray = new String[]{"","Minggu","Senin","Selasa","Rabu","Kamis","Jumat","Sabtu"};
        String[] monthArray = new String[]{"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

        String hari = formattedDate1.substring(formattedDate1.indexOf("-") + 1);
        String tanggalbulan = formattedDate1.substring(formattedDate1.indexOf("-") + 1);
        String tanggal = tanggalbulan.substring(tanggalbulan.lastIndexOf("-") + 1);
        String bulan = tanggalbulan.substring(0, tanggalbulan.indexOf("-"));
        String tahun = formattedDate1.substring(0, formattedDate1.indexOf("-"));

        int intbulan = Integer.parseInt(bulan);
        int date = c.get(Calendar.DAY_OF_WEEK);

        String fixtanggal = daysArray[date]+", " +tanggal+ " " + monthArray[intbulan - 1] + " " + tahun;

        Log.d("Tanggal sekarang", " = " + fixtanggal);

        isitanggal = fixtanggal.toString();

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db = new Database(getContext());

                List<DiagnosaHasilClassData> dataList = db.getallhasil();

                if ( dataList != null) {

                    db.hapushasil();

                    Log.e("Dihapus", " " );


                } else {



                }

                getActivity().finish();
            }
        });

        simpan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                db.insertgejala(new RiwayatClassData(null, penyakit.getText().toString().trim(), isitanggal.toString(), nilai.getText().toString().trim()));

                Toast.makeText(getContext(), "Data berhasil disimpan", Toast.LENGTH_SHORT).show();

//                db.hapushasil();

                Intent intent = new Intent(getContext(), Utama.class);
                startActivity(intent);

                db = new Database(getContext());

                List<DiagnosaHasilClassData> dataList = db.getallhasil();

                if ( dataList != null) {

                    db.hapushasil();

                    Log.e("Dihapus", " " );

                } else {

                }

            }
        });

        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();

                bundle.putString("penyakit", keypenyakit);
                bundle.putString("tanggal", isitanggal);
                bundle.putString("nilai", keynilai);

                fragment = new DiagnosaFragDetail();

                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });

    }
}
