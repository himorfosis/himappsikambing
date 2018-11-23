package com.dinaham.sikarbing;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class RiwayatFragHome extends Fragment {

    Database db;
    AlertDialog alertDialog;
    Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.riwayatfraghome, container, false);
    }

        public void onViewCreated(final View view, Bundle savedInstanceState) {

            setHasOptionsMenu(true);
            super.onViewCreated(view, savedInstanceState);
            getActivity().invalidateOptionsMenu();

            ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();

            final Button kembali = (Button) actionBar.getCustomView().findViewById(R.id.kembali);
            kembali.setVisibility(View.VISIBLE);

            ListView list = (ListView) view.findViewById(R.id.listriwayat);

            String data[] = null;
            db = new Database(getContext());

            final List<RiwayatClassData> dataList = db.getallriwayat();
            data = new String[dataList.size()];

            int i = 0;

            for (RiwayatClassData b : dataList) {

                data[i] = b.getId_riwayar()+ b.getPenyakit() + b.getNilai();

                i++;

                Log.e("penyaktt", " " +b.getPenyakit());
                Log.e("nilai", " " +b.getNilai());

            }

            final RiwayatListAdapter adapter = new RiwayatListAdapter(getContext(), dataList);
            list.setAdapter(adapter);

            list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                    final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                    final RiwayatClassData p = dataList.get(i);

                    builder.setTitle("Hapus data");
                    builder.setMessage("Apakah anda ingin menghapus data?");
                    builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {

                            db.deletegejala(String.valueOf(p.getId_riwayar()));

                        }
                    });

                    builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });

                    alertDialog = builder.create();
                    alertDialog.show();

                    return true;

                }
            });


            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    RiwayatClassData data = dataList.get(position);

                    Bundle bundle = new Bundle();

                    bundle.putString("penyakit", data.getPenyakit());
                    bundle.putString("tanggal", data.getTanggal());
                    bundle.putString("nilai", data.getNilai());

                    fragment = new RiwayatFragLihatData();

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
