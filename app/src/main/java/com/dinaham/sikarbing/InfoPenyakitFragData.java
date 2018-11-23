package com.dinaham.sikarbing;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class InfoPenyakitFragData extends Fragment {

    Fragment fragment;
    String data;
    ImageView gambar;
    TextView nama;
    TextView gejala;
    TextView datapenyakit;
    TextView pengendalian;
    TextView datapengendalian;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.infopenyakitfragdata, container, false);
    }

    public void onViewCreated(final View view, Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        super.onViewCreated(view, savedInstanceState);
        getActivity().invalidateOptionsMenu();

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        Button kembali = (Button) actionBar.getCustomView().findViewById(R.id.kembali);
        gambar = (ImageView) view.findViewById(R.id.gambarpenyakit);
        nama = (TextView) view.findViewById(R.id.namapenyakit);
        gejala = (TextView) view.findViewById(R.id.gejala);
        datapenyakit = (TextView) view.findViewById(R.id.datapenyakit);
        pengendalian = (TextView) view.findViewById(R.id.pengendalian);
        datapengendalian = (TextView)view.findViewById(R.id.datapengendalian);

        gejala.setText("Gejala - gejala : ");
        pengendalian.setText("Pengendalian penyakit : ");

        savedInstanceState = getArguments();
        if (savedInstanceState == null){

        }else {
            data = savedInstanceState.getString("data");
        }

        Log.e("data", " " + data.toString());

        if (data.equals("scabies")){

            gambar.setImageResource(R.drawable.sscabies);
            nama.setText("Scabies");

            datapenyakit.setText("1. Hewan akan menggesek-gesekkan daerah yang gatal ke tiang kandang. \n\n"
            + "2. Lesu, tidak ada nafsu makan. \n\n" +
                    "3. Kulit tampak menebal, berkerak, turgor kulit jelek, bulu rontok. \n");

            datapengendalian.setText("1. Menghindari kontak lansung dengan kambing yang terkena penyakit ini. \n\n" +
                    "2. Sanitasi kandang. \n\n" +
                    "3. Bila salah satu kambing menunjukan gejala penyakit scabies, kambing tersebut segera isolasi. \n");

        } else if (data.equals("mastitis")){

            gambar.setImageResource(R.drawable.mastitis);
            nama.setText("Mastitis");
            datapenyakit.setText("1. Meningkatnya suhu badan dan frekuensi pernafasan ternak.\n\n" +
                    "2. Nafsu makan ternak akan menurun secara drastis. \n\n" +
                    "3. Adanya perubahan air susu kambing seperti perubahan warna seperti kekuning-kuningan dan mengandung nanah. \n\n" +
                    "4. Peradangan dan perubahan bentuk ambing. \n\n" +
                    "5. Ambing dapat berwarna kebiruan. \n\n" +
                    "6. Ada pembengkakan ambing. \n\n" +
                    "7. Ternak kambing mengalami dehidrasi, depresi, bisa menyebabkan kematian. \n");

            datapengendalian.setText("1. Memakai antiseptik guna penceluppan puting susu saat sebelum dan setelah pemerahan. \n\n" +
                    "2. Menjaga kandang agar tetap bersih. \n\n" +
                    "3. Membersihkan ambing secara rutin. \n");

        } else if (data.equals("pneumonia")){

            gambar.setImageResource(R.drawable.pneumonia);
            nama.setText("Pneumonia");
            datapenyakit.setText("1. Pernafasan yang mula-mula dangkal. \n\n" +
                    "2. Penderita dalam beberapa hari akan memperlihatkan gejala batuk. \n\n" +
                    "3. Leleran hidung berwarna kekuningan. \n");

            datapengendalian.setText("1. Menghindari terjadinya stres pada ternak yang dapat menyebabkan pneumonia, seperti ternak dalam " +
                    "kepadatan kandang tinggi (overcrowded), temperatur dingin, kelembapan tinggi, dan kondisi transportasi yang buruk. Kandang selalu dalam keadaan bersih dan kering.");

        } else if (data.equals("hipokalsemia")){

            gambar.setImageResource(R.drawable.hipokalsemia);
            nama.setText("Hipokalsemia");
            datapenyakit.setText("1. Hipokalsemia biasa menimbulkan lemah tiba-tiba. \n\n" +
                    "2. Tidak bisa mengangkat leher. \n\n" +
                    "3. Nafsu makan turun. \n\n" +
                    "4. Cuping hidung kering. \n\n" +
                    "5. Tremor atau kejang otot. \n\n" +
                    "6. Suhu tubuh turun, bahkan diiringi indikasi kembung. \n");

            datapengendalian.setText("1. Menghindarkan faktor-faktor yang memudahkan kearah terjadinya hipokalsemia. \n\n" +
                    "2. Pemberian pakan yang berasal dari hijauan yang banyak mengandung oksalat sebaiknya dihindarkan. \n\n" +
                    "3. Sedangkan pakan yang kurang kalsium seharusnya ditambah dengan 1-2% batu kapur. \n");

        } else if (data.equals("pinkeye")){

            gambar.setImageResource(R.drawable.pink_eye);
            nama.setText("Pink Eye");
            datapenyakit.setText("1. Hewan penderita mengalami demam. \n\n" +
                    "2. Depresi dan penurunan nafsu makan. \n\n" +
                    "3. Mata mengalami konjunctivitis, kreatitis, kekeruhan kornea dan lakrimasi. \n");

            datapengendalian.setText("1. Memusnahkan hewan karier yaitu hewan yang dianggap sebagai sumber infeksi segera diisolasi dari kawanan ternak. \n\n" +
                    "2. Hewan yang terinfeksi segera dikandangkan (isolasi) pada tempat yang gelap. \n\n" +
                    "3. Menjaga kebersihan kandang serta lingkungan. \n\n" +
                    "4. Pemberian makanan yang cukup mengandung vitamin A. \n");

        } else if (data.equals("kembung")){

            gambar.setImageResource(R.drawable.kembung);
            nama.setText("Kembung atau Bloat");
            datapenyakit.setText("1. Perut kambing yang membesar atau membengkak akibat penumpukan gas dalam rumen. \n\n" +
                    "2. Rasa sakit yang ditimbulkan akan membuat kambing mendengus dan umumnya akan menendang–nendang ke sisi kiri. \n\n" +
                    "3. Punggung kambing juga membungkuk, serta saat berbaring kambing akan sulit untuk bangun kembali. \n");

            datapengendalian.setText("1. Dinding kandang sebaiknya dibuat rapat agar ternak tetap hangat saat udara dingin dimalam hari atau saat turun hujan. \n\n" +
                    "2. Hindari memberi pakan dari hijauan kacang-kacangan secara berlebihan. \n\n" +
                    "3. Pilih lokasi untuk menempatkan kandang pada tempat yang kering dan tidak lembab. \n");

        } else if (data.equals("cacingan")){

            gambar.setImageResource(R.drawable.cacingan);
            nama.setText("Cacingan");
            datapenyakit.setText("1. Kambing menjadi lemah, lesu dan tidak bisa gemuk walaupun diberi makan banyak. \n\n" +
                    "2. Nafsu makan berkurang. \n\n" +
                    "3. Perut buncit. \n\n" +
                    "4. Bulu terasa kasar, kusam dan rontok. \n\n" +
                    "5. Kambing pun mengalami diare atau mencret. \n\n" +
                    "6. Konjungtiva anemis (pucat putih kekuningan). \n");

            datapengendalian.setText("1. Menjaga kebersihan kandang. \n\n" +
                    "2. Memberikan obat cacing secara teratur, boleh 3 bulan sekali, 6 bulan sekali atau paling lambat setahun sekali. \n");

        } else if (data.equals("orf")){

            gambar.setImageResource(R.drawable.orf);
            nama.setText("Orf atau Keropang Mulut");
            datapenyakit.setText("1. Luka disekitar mulut yang berupa keropeng hitam dan terdapat juga benjolan. \n");

            datapengendalian.setText("1. Pemberian vaksinasi. \n\n" +
                    "2. Pengkarantinaan agar tidak terjadi penyebaran. \n");

        } else if (data.equals("antraks")){

            gambar.setImageResource(R.drawable.antraks);
            nama.setText("Antraks");
            datapenyakit.setText("1. Demam yang tinggi hingga tubuh gemetar. \n\n" +
                    "2. Badan lemas. \n\n" +
                    "3. Gangguan pernafasan. \n\n" +
                    "4. Pembengkakakan kelenjar dada. \n\n" +
                    "5. Dada penuh bisul. \n\n" +
                    "6. Gangguan pencernaan. \n\n" +
                    "7. Mengeluarkan darah dari telinga, mulut, dan anus. \n\n" +
                    "8. Terjadi kematian mendadak. \n");

            datapengendalian.setText("1. Belum ada obatnya, jadi pengendalian penyakit adalah dengan dikuburkan dan membakar ternak yang mati terserang Antraks. \n\n" +
                    "2. Segera lapor ke Dinas Peternakan. (Penyakit antraks dapat menular ke manusia apabila peternak makan ternak yang terserang antraks). \n");

        } else if (data.equals("kukubusuk")){

            gambar.setImageResource(R.drawable.kuku_busuk);
            nama.setText("Kuku Busuk");
            datapenyakit.setText("1. Celah kuku bengkak. \n\n" +
                    "2. Mengeluarkan cairan putih keruh (nanah). \n\n" +
                    "3. Kulit kuku mengelupas. \n\n" +
                    "4. Ada pembusukan di daerah teracak (telapak kaki) sehingga dapat terjadi kelumpuhan atau kesusahan berdiri. \n");

            datapengendalian.setText("1. Bersihkan dan potong kukunya, siramkan alkohol lalu perban kaki kambing dan hindarkan dari tempat kotor yang tergenang air. \n");

        } else if (data.equals("keguguran")){

            gambar.setImageResource(R.drawable.keguguran1);
            nama.setText("Brucellosis atau Keguguran");
            datapenyakit.setText("1. Terjadi keguguran (abortus). \n\n" +
                    "2. Cairan janin berwarna keruh saat keguguran. \n\n" +
                    "3. Terjadi kebengkakan pada persendian atau testes (pejantan). \n\n" +
                    "4. Pada susu tidak ada gejala secara klinis yang menunjukkan adanya bakteri brucella. \n\n" +
                    "5. Terjadi penurunan produksi susu secara tiba-tiba (kambing perah). \n");

            datapengendalian.setText("1. Karena penyakit ini bersifat persisten seumur hidup perlu dilakukan tindakan vaksinasi dan sanitasi, serta tata cara dalam pemeliharaan. \n\n" +
                    "2. Ternak betina yang telah keguguran segera bersihkan dan didesinfeksi dengan desinfektan terutama pad abagian vagina. Fetus dan plasenta harus segera dibakar. \n\n" +
                    "3. Letakkan ternak yang terinfeksi bakteri brucella diletakkan pada kandang yang terpisah dengan ternak lainnya. \n");

        }

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragment = new InfoPenyakitFragHome();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container, fragment);
                ft.commit();
            }
        });

    }
}
