package com.dinaham.sikarbing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by him on 6/28/2018.
 */

public class Bantuan extends AppCompatActivity {

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bantuan);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar);

        TextView judul = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbartext);
        judul.setText("Bantuan");
        Button kembali = (Button) getSupportActionBar().getCustomView().findViewById(R.id.kembali);

        TextView isijudul = (TextView) findViewById(R.id.judul);
        TextView isi = (TextView) findViewById(R.id.cara);

        Intent intent = getIntent();

        String getData = intent.getStringExtra("key");

        Log.e("get data value", "" +getData);

        if (getData.equals("diagnosa")) {

            isijudul.setText("Cara mendiagnosa kambing :");
            isi.setText("1. Pada halaman Beranda, silahkan memilih menu Diagnosa.\n\n" +
                    "2. Silahkan memilih gejala yang sesuai dengan kambing yang akan didiagnosa.\n\n" +
                    "3. Silahkan memilih tombol Cek Diagnosa.\n\n" +
                    "4. Aplikasi akan otomatis memunculkan hasil dari gejala – gejala yang dipilih.\n\n" +
                    "5. Silahkan memilih tombol Detail Penyakit jika ingin melihat detail penyakit sesuai dengan hasil yang diperoleh.\n\n" +
                    "6. Silahkan memilih tombol Simpan jika ingin  menyimpan diagnosa kambing.\n");

        } else if (getData.equals("infopenyakit")) {

            isijudul.setText("Cara melihat Info Penyakit :");
            isi.setText("1. Pada halaman Beranda, silahkan memilih menu Info Penyakit.\n\n" +
                    "2. Maka aplikasi akan menampilkan isi info penyakit.\n\n" +
                    "3. Silahkan pilih nama penyakit untuk melihat info – info penyakit.\n");

        } else if (getData.equals("riwayat")) {

            isijudul.setText("Cara melihat Riwayat :");
            isi.setText("1. Pada halaman Beranda, silahkan memilih menu Riwayat.\n\n" +
                    "2. Maka aplikasi akan menampilkan kumpulan riwayat diagnosa yang pernah dilakukan sebelumnya.\n");

        }

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

    }
}
