package com.dinaham.sikarbing;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class Utama extends AppCompatActivity {

    private TabLayout tabLayout;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.utama);

        db = new Database(getApplicationContext());

        List<DiagnosaHasilClassData> dataList = db.getallhasil();

        if ( dataList != null) {

            db.hapushasil();

            Log.e("Dihapus", " " );


        } else {

        }

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.beranda1));
        tabLayout.getTabAt(0).setText("Beranda");

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.bantuan));
        tabLayout.getTabAt(1).setText("Bantuan");

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.pengguna));
        tabLayout.getTabAt(2).setText("Tentang");

        replaceFragment(new UtamaFragBeranda());

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                tab.getPosition();
//                tab.getText();

                if (tab.getPosition() == 0) {
                    tabLayout.getTabAt(0).setText("Beranda");

                    tabLayout.getTabAt(0).setIcon(R.drawable.beranda1);
                    //    tabLayout.getTabAt(0).setText("Beranda");
                    replaceFragment(new UtamaFragBeranda());
                } else if (tab.getPosition() == 1) {
                    tabLayout.getTabAt(1).setText("Bantuan");

                    tabLayout.getTabAt(1).setIcon(R.drawable.bantuan1);
                    //    tabLayout.getTabAt(1).setText("Kalender");
                    replaceFragment(new UtamaFragBantuan());
                } else {
                    tabLayout.getTabAt(2).setText("Tentang");

                    tabLayout.getTabAt(2).setIcon(R.drawable.pengguna1);
                    //    tabLayout.getTabAt(2).setText("Pengaturan");
                    replaceFragment(new UtamaFragPengguna());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    tabLayout.getTabAt(0).setText("Beranda");

                    tabLayout.getTabAt(0).setIcon(R.drawable.beranda);
                    // tabLayout.getTabAt(0).setText("Beranda");
                } else if (tab.getPosition() == 1) {
                    tabLayout.getTabAt(1).setText("Bantuan");

                    tabLayout.getTabAt(1).setIcon(R.drawable.bantuan);
                    //  tabLayout.getTabAt(1).setText("Kalender");
                } else if (tab.getPosition() == 2) {
                    tabLayout.getTabAt(2).setText("Tentang");

                    tabLayout.getTabAt(2).setIcon(R.drawable.pengguna);
                    //   tabLayout.getTabAt(1).setText("Kalender");
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }



    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);

        transaction.commit();
    }

}
