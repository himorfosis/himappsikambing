package com.dinaham.sikarbing;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiagnosaPilihData extends Fragment {

    Fragment fragment;
    String data;
    TextView bagian;

    SparseBooleanArray sparseBooleanArray;

    String valuegejala = "";

    ArrayList<String> deret = new ArrayList<String>();

    ArrayList<Double> Scabies = new ArrayList<Double>();
    ArrayList<Double> Mastitis = new ArrayList<Double>();
    ArrayList<Double> Pneumonia = new ArrayList<Double>();
    ArrayList<Double> Hipokalsemia = new ArrayList<Double>();
    ArrayList<Double> PinkEye = new ArrayList<Double>();
    ArrayList<Double> Kembung = new ArrayList<Double>();
    ArrayList<Double> Cacingan = new ArrayList<Double>();
    ArrayList<Double> Orf = new ArrayList<Double>();
    ArrayList<Double> Antraks = new ArrayList<Double>();
    ArrayList<Double> KukuBusuk = new ArrayList<Double>();
    ArrayList<Double> Keguguran = new ArrayList<Double>();

    Double sca, mas, pne, hipo, pink, kemb, caci, or, antr, kuku, kegu;
    Double HasilScabies, HasilMastitis, HasilPnemonia, HasilHipokalsemia, HasilPinkeye, HasilKembung, HasilCacingan, HasilOrf, HasilAntraks, HasilKukuBusuk, HasilKeguguran;

    Double empty = 0.1;
    String valuefix;
    String penyakitfix;

    String penyakitprob;
    String valueprob;

    Database db;

    public static DecimalFormat df2 = new DecimalFormat("#.##");
    public static DecimalFormat hasil = new DecimalFormat("#.####");
    public static DecimalFormat fixhasil = new DecimalFormat("##.##");
    int index = 0;

    ArrayList<ClassDataGejala> daftargejala = new ArrayList<>();
    List<Double> Descending = new ArrayList<Double>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.diagnosapilihdata, container, false);
    }

    public void onViewCreated(final View view, Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        super.onViewCreated(view, savedInstanceState);
        getActivity().invalidateOptionsMenu();

        db = new Database(getContext());

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        final Button kembali = (Button) actionBar.getCustomView().findViewById(R.id.kembali);
        kembali.setVisibility(View.VISIBLE);

//        bagian = (TextView) view.findViewById(R.id.bagian);
//        Button tambahgejala = (Button) view.findViewById(R.id.tambahgejala);
        final Button hasildiagnosa = (Button) view.findViewById(R.id.cekdiagnosa);
        final ListView list = (ListView) view.findViewById(R.id.diagnosalistgejala);

        daftargejala.add(new ClassDataGejala("Leleran hidung berwarna kekuningan", "0.9"));
        daftargejala.add(new ClassDataGejala("Tidak bisa mengangkat leher", "0.7"));
        daftargejala.add(new ClassDataGejala("Cuping hidung kering", "0.8"));
        daftargejala.add(new ClassDataGejala("Mata mengalami konjunctivitis, kreatitis, kekeruhan kornea dan lakrimasi", "0.9"));
//        daftargejala.add(new ClassDataGejala("Konjungtiva anemis Warna mata pucat putih kekuningan", "0.8"));
        daftargejala.add(new ClassDataGejala("Luka disekitar mulut yang berupa keropeng hitam dan terdapat juga benjolan", "0.9"));
        daftargejala.add(new ClassDataGejala("Mengeluarkan darah dari telinga, mulut, dan anus", "0.9"));

//        } else if (data.equals("badan")) {

        daftargejala.add(new ClassDataGejala("Kulit tampak menebal, berkerak, turgor kulit jelek, bulu rontok", "0.9"));
        daftargejala.add(new ClassDataGejala("Perut kambing yang membesar atau membengkak akibat penumpukan gas dalam rumen", "0.9"));
        daftargejala.add(new ClassDataGejala("Punggung kambing juga membungkuk, serta saat berbaring kambing akan sulit untuk bangun kembali", "0.7"));
        daftargejala.add(new ClassDataGejala("Perut buncit", "0.8"));
//        daftargejala.add(new ClassDataGejala("Pembengkakan kelenjar dada", "0.3"));
        daftargejala.add(new ClassDataGejala("Dada penuh bisul", "0.3"));

//        } else if (data.equals("kaki")) {

        daftargejala.add(new ClassDataGejala("Celah kuku bengkak", "0.8"));
        daftargejala.add(new ClassDataGejala("Megeluarkan cairan putih keruh", "0.8"));
        daftargejala.add(new ClassDataGejala("Kulit kuku mengelupas", "0.8"));

//        } else if (data.equals("ambing")) {

        daftargejala.add(new ClassDataGejala("Adanya perubahan air susu kambing seperti perubahan warna seperti kekuning-kuningan dan mengandung nanah", "0.9"));
        daftargejala.add(new ClassDataGejala("Peradangan dan perubahan bentuk ambing", "0.9"));
        daftargejala.add(new ClassDataGejala("Ambing dapat berwarna kebiruan", "0.9"));
        daftargejala.add(new ClassDataGejala("Ada pembengkakan ambing", "0.9"));
        daftargejala.add(new ClassDataGejala("Pada susu tidak ada gejala secara klinis yang menunjukkan adanya bakteri brucella", "0.9"));
        daftargejala.add(new ClassDataGejala("Terjadi penurunan produksi susu secara tiba-tiba (kambing perah)", "0.2"));

//        } else if (data.equals("reproduksi")) {

        daftargejala.add(new ClassDataGejala("Terjadi keguguran (abortus)", "0.9"));
        daftargejala.add(new ClassDataGejala("Cairan janin berwarna keruh saat keguguran", "0.9"));
        daftargejala.add(new ClassDataGejala("Terjadi kebengkakan pada persendian atau testes (pejantan)", "0.4"));

//        } else if (data.equals("lainlain")) {

        daftargejala.add(new ClassDataGejala("Hewan akan menggesek-gesekkan daerah yang gatal ke tiang kandang", "0.9"));
        daftargejala.add(new ClassDataGejala("Lesu, tidak ada nafsu makan", "0.7"));
        daftargejala.add(new ClassDataGejala("Nafsu makan ternak akan menurun drastis", "0.8"));
//        daftargejala.add(new ClassDataGejala("Nafsu makan turun", "0.5"));
        daftargejala.add(new ClassDataGejala("Depresi dan penurunan nafsu makan", "0.3"));
        daftargejala.add(new ClassDataGejala("Nafsu makan berkurang", "0.7"));
        daftargejala.add(new ClassDataGejala("Meningkatnya suhu badan dan frekuensi pernafasan ternak", "0.8"));
        daftargejala.add(new ClassDataGejala("Ternak kambing mengalami dehidrasi, depresi, bisa menyebabkan kematian", "0.9"));
        daftargejala.add(new ClassDataGejala("Pernafasan yang mula-mula dangkal", "0.8"));
        daftargejala.add(new ClassDataGejala("Penderita dalam beberapa hari akan memperlihatkan gejala batuk", "0.2"));
        daftargejala.add(new ClassDataGejala("Lemah tiba-tiba", "0.7"));
        daftargejala.add(new ClassDataGejala("Tremor atau kejang otot", "0.8"));
        daftargejala.add(new ClassDataGejala("Suhu tubuh turun, bahkan diiringi indikasi kembung", "0.9"));
        daftargejala.add(new ClassDataGejala("Hewan penderita mengalami demam", "0.2"));
        daftargejala.add(new ClassDataGejala("Rasa sakit yang ditimbulkan akan membuat kambing mendengus dan umumnya akan menendang–nendang ke sisi kiri", "0.5"));
        daftargejala.add(new ClassDataGejala("Lemah, lesu, dan tidak bisa gemuk", "0.8"));
        daftargejala.add(new ClassDataGejala("Kambing mengalami diare atau mencret", "0.7"));
        daftargejala.add(new ClassDataGejala("Demam yang tinggi hingga tubuh gemetar", "0.8"));
        daftargejala.add(new ClassDataGejala("Badan lemas", "0.4"));
        daftargejala.add(new ClassDataGejala("Gangguan pernafasan", "0.7"));
        daftargejala.add(new ClassDataGejala("Gangguan pencernaan", "0.4"));
        daftargejala.add(new ClassDataGejala("Terjadi kematian mendadak", "0.9"));
        daftargejala.add(new ClassDataGejala("Kambing menjadi lemah, lesu dan tidak bisa gemuk walaupun diberi makan banyak", "0.8"));
        daftargejala.add(new ClassDataGejala("Bulu terasa kasar, kusam dan rontok", "0.8"));
        daftargejala.add(new ClassDataGejala("Kambing pun mengalami diare atau mencret", "0.7"));
        daftargejala.add(new ClassDataGejala("Konjungtiva anemis pucat putih kekuningan", "0.8"));
        daftargejala.add(new ClassDataGejala("Pembengkakakan kelenjar dada", "0.3"));
        daftargejala.add(new ClassDataGejala("Mengeluarkan cairan putih keruh (nanah)", "0.8"));
        daftargejala.add(new ClassDataGejala("Ada pembusukan di daerah teracak (telapak kaki) sehingga dapat terjadi kelumpuhan atau kesusahan berdiri", "0.8"));


        final DiagnosaListAdapter adapter = new DiagnosaListAdapter(getContext(), android.R.layout.simple_list_item_multiple_choice, daftargejala);

        list.setChoiceMode(list.CHOICE_MODE_MULTIPLE);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                ClassDataGejala p = daftargejala.get(i);

                if (list.isItemChecked(i)) {

                    if (!deret.contains(p.getGejala())) {

                        deret.add(p.getGejala());

                    }

                } else {

                    if (deret.contains(p.getGejala())) {
                        deret.remove(p.getGejala());
                    }

                }

                Log.e("Deret ", ": " + deret);


            }
        });


        hasildiagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (deret.toString().length() == 0) {

                    Toast.makeText(getContext(), "Harap isi data", Toast.LENGTH_SHORT).show();

                } else {


                    for (int i = 0; i < deret.size(); i++) {

//                    Log.e("deret", " " + deret);

                        if (deret.get(i).toString().equals(Gejala.satu)) {

                            Double a = 0.9;
                            Scabies.add(a);

                            Log.e("1", " " + deret.get(i));

                        }
                        if (deret.get(i).toString().equals(Gejala.dua)) {

                            Double a = 0.7;
                            Scabies.add(a);

                            Log.e("Dua", " " + deret.get(i));

                        }
                        if (deret.get(i).toString().equals(Gejala.tiga)) {

                            Double a = 0.9;
                            Scabies.add(a);

                            Log.e("Tiga", " " + deret.get(i));

                        }
                        if (deret.get(i).toString().equals(Gejala.empat)) {

                            Double a = 0.8;
                            Mastitis.add(a);

                            Log.e("empat", " " + deret.get(i));

                        }
                        if (deret.get(i).toString().equals(Gejala.lima)) {

                            Double a = 0.7;
                            Mastitis.add(a);

                            Log.e("lima", " " + deret.get(i));

                        }
                        if (deret.get(i).toString().equals(Gejala.enam)) {

                            Double a = 0.9;
                            Mastitis.add(a);

                            Log.e("enam", " " + deret.get(i));

                        }
                        if (deret.get(i).toString().equals(Gejala.tujuh)) {

                            Double a = 0.9;
                            Mastitis.add(a);

                            Log.e("tujuh", " " + deret.get(i));

                        }
                        if (deret.get(i).toString().equals(Gejala.delapan)) {

                            Double a = 0.9;
                            Mastitis.add(a);

                            Log.e("delapan", " " + deret.get(i));

                        }
                        if (deret.get(i).toString().equals(Gejala.sembilan)) {

                            Double a = 0.9;
                            Mastitis.add(a);

                            Log.e("sembilan", " " + deret.get(i));

                        }
                        if (deret.get(i).toString().equals(Gejala.sepuluh)) {

                            Double a = 0.9;
                            Mastitis.add(a);

                            Log.e("10 ", " " + deret.get(i));

                        }
                        if (deret.get(i).toString().equals(Gejala.sebelas)) {

                            Double a = 0.8;
                            Pneumonia.add(a);

                            Log.e("11", " " + deret.get(i));

                        }
                        if (deret.get(i).toString().equals(Gejala.duabelas)) {

                            Double a = 0.2;
                            Pneumonia.add(a);

                            Log.e("12", " " + deret.get(i));

                        }
                        if (deret.get(i).toString().equals(Gejala.tigabelas)) {

                            Double a = 0.9;
                            Pneumonia.add(a);

                            Log.e("13", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.empatbelas)) {

                            Double a = 0.7;
                            Hipokalsemia.add(a);

                            Log.e("14", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.limabelas)) {

                            Double a = 0.7;
                            Hipokalsemia.add(a);

                            Log.e("15", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.enambelas)) {

                            Double a = 0.7;
                            Hipokalsemia.add(a);

                            Log.e("16", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.tujuhbelas)) {

                            Double a = 0.8;
                            Hipokalsemia.add(a);

                            Log.e("17", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.delapanbelas)) {

                            Double a = 0.8;
                            Hipokalsemia.add(a);

                            Log.e("18", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.sembilanbelas)) {

                            Double a = 0.9;
                            Hipokalsemia.add(a);

                            Log.e("19", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.duapuluh)) {

                            Double a = 0.2;
                            PinkEye.add(a);

                            Log.e("20", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.duasatu)) {

                            Double a = 0.3;
                            PinkEye.add(a);

                            Log.e("21", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.duadua)) {

                            Double a = 0.9;
                            PinkEye.add(a);

                            Log.e("22", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.duatiga)) {

                            Double a = 0.9;
                            Kembung.add(a);

                            Log.e("23", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.duaempat)) {

                            Double a = 0.5;
                            Kembung.add(a);

                            Log.e("24", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.dualima)) {

                            Double a = 0.7;
                            Kembung.add(a);

                            Log.e("25", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.duaenam)) {

                            Double a = 0.8;
                            Cacingan.add(a);

                            Log.e("26", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.duatujuh)) {

                            Double a = 0.7;
                            Cacingan.add(a);

                            Log.e("27", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.duadelapan)) {

                            Double a = 0.8;
                            Cacingan.add(a);

                            Log.e("28", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.duasembilan)) {

                            Double a = 0.8;
                            Cacingan.add(a);

                            Log.e("29", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.tigapuluh)) {

                            Double a = 0.7;
                            Cacingan.add(a);

                            Log.e("30", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.tigasatu)) {

                            Double a = 0.8;
                            Cacingan.add(a);

                            Log.e("31", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.tigadua)) {

                            Double a = 0.9;
                            Orf.add(a);

                            Log.e("32", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.tigatiga)) {

                            Double a = 0.8;
                            Antraks.add(a);

                            Log.e("33", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.tigaempat)) {

                            Double a = 0.4;
                            Antraks.add(a);

                            Log.e("34", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.tigalima)) {

                            Double a = 0.7;
                            Antraks.add(a);

                            Log.e("35", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.tigaenam)) {

                            Double a = 0.3;
                            Antraks.add(a);

                            Log.e("36", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.tigatujuh)) {

                            Double a = 0.3;
                            Antraks.add(a);

                            Log.e("37", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.tigadelapan)) {

                            Double a = 0.4;
                            Antraks.add(a);

                            Log.e("38", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.tigasembilan)) {

                            Double a = 0.9;
                            Antraks.add(a);

                            Log.e("39", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.empatpuluh)) {

                            Double a = 0.9;
                            Antraks.add(a);

                            Log.e("40", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.empatsatu)) {

                            Double a = 0.8;
                            KukuBusuk.add(a);

                            Log.e("41", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.empatdua)) {

                            Double a = 0.8;
                            KukuBusuk.add(a);

                            Log.e("42", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.empattiga)) {

                            Double a = 0.8;
                            KukuBusuk.add(a);

                            Log.e("43", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.empatempat)) {

                            Double a = 0.8;
                            KukuBusuk.add(a);

                            Log.e("44", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.empatlima)) {

                            Double a = 0.9;
                            Keguguran.add(a);

                            Log.e("45", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.empatenam)) {

                            Double a = 0.9;
                            Keguguran.add(a);

                            Log.e("46", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.empattujuh)) {

                            Double a = 0.4;
                            Keguguran.add(a);

                            Log.e("47", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.empatdelapan)) {

                            Double a = 0.9;
                            Keguguran.add(a);

                            Log.e("48", " " + deret.get(i));
                        }
                        if (deret.get(i).toString().equals(Gejala.empatsembilan)) {

                            Double a = 0.2;
                            Keguguran.add(a);

                            Log.e("49", " " + deret.get(i));
                        }

                        Log.e("hasil deret", " " + deret.get(i).toString());

                    }

                    if (Scabies.isEmpty()) {
                        Scabies.add(empty);
                    }

                    if (Mastitis.isEmpty()) {
                        Mastitis.add(empty);
                    }

                    if (Pneumonia.isEmpty()) {
                        Pneumonia.add(empty);
                    }
                    if (Hipokalsemia.isEmpty()) {
                        Hipokalsemia.add(empty);
                    }
                    if (PinkEye.isEmpty()) {
                        PinkEye.add(empty);
                    }
                    if (Kembung.isEmpty()) {
                        Kembung.add(empty);
                    }
                    if (Cacingan.isEmpty()) {
                        Cacingan.add(empty);
                    }
                    if (Orf.isEmpty()) {
                        Orf.add(empty);
                    }
                    if (Antraks.isEmpty()) {
                        Antraks.add(empty);
                    }
                    if (KukuBusuk.isEmpty()) {
                        KukuBusuk.add(empty);
                    }
                    if (Keguguran.isEmpty()) {
                        Keguguran.add(empty);
                    }


                    //mengambil data dan jumlah scabies

                    for (int i = 0; i < Scabies.size(); i++) {

                        Double scabies = 0.1;

                        scabies = scabies * Scabies.get(i);
                        Log.e("Scabies", " " + df2.format(scabies));

                        sca = scabies;

                        HasilScabies = sca * 0.8;

                    }

                    for (int i = 0; i < Mastitis.size(); i++) {

                        Double mastitis = 0.1;

                        mastitis = mastitis * Mastitis.get(i);
                        Log.e("Mastitis", " " + df2.format(mastitis));

                        mas = mastitis;
                        HasilMastitis = mas * 0.8;

                    }

                    for (int i = 0; i < Pneumonia.size(); i++) {

                        Double pneumonia = 0.1;

                        pneumonia = pneumonia * Pneumonia.get(i);
                        Log.e("Pneumonia", " " + df2.format(pneumonia));

                        pne = pneumonia;
                        HasilPnemonia = pne * 0.8;

                    }

                    for (int i = 0; i < Hipokalsemia.size(); i++) {

                        Double hipokalsemia = 0.1;

                        hipokalsemia = hipokalsemia * Hipokalsemia.get(i);
                        Log.e("Hipokalsemia", " " + df2.format(hipokalsemia));

                        hipo = hipokalsemia;
                        HasilHipokalsemia = hipo * 0.4;

                    }

                    for (int i = 0; i < PinkEye.size(); i++) {

                        Double pinkeye = 0.1;

                        pinkeye = pinkeye * PinkEye.get(i);

                        Log.e("Pink Eye", " " + df2.format(pinkeye));

                        pink = pinkeye;
                        HasilPinkeye = pink * 0.8;

                    }

                    for (int i = 0; i < Kembung.size(); i++) {

                        Double kembung = 0.1;

                        kembung = kembung * Kembung.get(i);
                        Log.e("Kembung", " " + df2.format(kembung));

                        kemb = kembung;
                        HasilKembung = kemb * 0.7;

                    }

                    for (int i = 0; i < Cacingan.size(); i++) {

                        Double cacingan = 0.1;

                        cacingan = cacingan * Cacingan.get(i);
                        Log.e("Cacingan", " " + df2.format(cacingan));

                        caci = cacingan;
                        HasilCacingan = caci * 0.6;

                    }

                    for (int i = 0; i < Orf.size(); i++) {

                        Double orf = 0.1;

                        orf = orf * Orf.get(i);
                        Log.e("Orf", " " + df2.format(orf));

                        or = orf;
                        HasilOrf = or * 0.4;

                    }

                    for (int i = 0; i < Antraks.size(); i++) {

                        Double antraks = 0.1;

                        antraks = antraks * Antraks.get(i);
                        Log.e("Antraks", " " + df2.format(antraks));

                        antr = antraks;
                        HasilAntraks = antr * 0.4;

                    }

                    for (int i = 0; i < KukuBusuk.size(); i++) {

                        Double kukubusuk = 0.1;

                        kukubusuk = kukubusuk * KukuBusuk.get(i);
                        Log.e("Kuku busuk", " " + df2.format(kukubusuk));

                        kuku = kukubusuk;
                        HasilKukuBusuk = kuku * 0.4;

                    }

                    for (int i = 0; i < Keguguran.size(); i++) {

                        Double keguguran = 0.1;

                        keguguran = keguguran * Keguguran.get(i);
                        Log.e("Keguguran", " " + df2.format(keguguran));

                        kegu = keguguran;

                        HasilKeguguran = kegu * 0.4;

                    }

                    Log.e("Hasil Scabies", " " + hasil.format(HasilScabies));
                    Log.e("Hasil Mastitis", " " + hasil.format(HasilMastitis));
                    Log.e("Hasil phenomia", " " + hasil.format(HasilPnemonia));
                    Log.e("Hasil Hipokalsemia", " " + hasil.format(HasilHipokalsemia));
                    Log.e("Hasil Pinkeye", " " + hasil.format(HasilPinkeye));
                    Log.e("Hasil Kembung", " " + hasil.format(HasilKembung));
                    Log.e("Hasil Cacingan", " " + hasil.format(HasilCacingan));
                    Log.e("Hasil Orf", " " + hasil.format(HasilOrf));
                    Log.e("Hasil Antraks", " " + hasil.format(HasilAntraks));
                    Log.e("Hasil Kuku busuk", " " + hasil.format(HasilKukuBusuk));
                    Log.e("Hasil Keguguran", " " + hasil.format(HasilKeguguran));

                    Double totaldiagnosa = HasilScabies + HasilMastitis + HasilPnemonia + HasilPinkeye + HasilKembung + HasilCacingan + HasilOrf + HasilAntraks + HasilKukuBusuk + HasilKeguguran;
                    Log.e("Total diagnosa", " " + totaldiagnosa);

//                List<Double> Descending = new ArrayList<Double>();

                    Double fixscabies = (HasilScabies / totaldiagnosa) * 100.f;
                    Log.e("fix scabies", " " + fixhasil.format(fixscabies));
                    Descending.add(fixscabies);

//                Utilities.ShowToast(getContext(), "Hasil scabies" +fixhasil.format(fixscabies));

                    Double fixmastitis = (HasilMastitis / totaldiagnosa) * 100.f;
                    Log.e("fix mastitis", " " + fixhasil.format(fixmastitis));
                    Descending.add(fixmastitis);

                    Double fixpnemonia = (HasilPnemonia / totaldiagnosa) * 100.f;
                    Log.e("fix pnemonia", " " + fixhasil.format(fixpnemonia));
                    Descending.add(fixpnemonia);

                    Double fixhipo = (HasilHipokalsemia / totaldiagnosa) * 100.f;
                    Log.e("fix Hipokalsemia", " " + fixhasil.format(fixhipo));
                    Descending.add(fixhipo);

                    Double fixpink = (HasilPinkeye / totaldiagnosa) * 100.f;
                    Log.e("fix pink eye", " " + fixhasil.format(fixpink));
                    Descending.add(fixpink);

                    Double fixkembung = (HasilKembung / totaldiagnosa) * 100.f;
                    Log.e("fix kembung", " " + fixhasil.format(fixkembung));
                    Descending.add(fixkembung);

                    Double fixcacingan = (HasilCacingan / totaldiagnosa) * 100.f;
                    Log.e("fix cacingan", " " + fixhasil.format(fixcacingan));
                    Descending.add(fixcacingan);

                    Double fixorf = (HasilOrf / totaldiagnosa) * 100.f;
                    Log.e("fix orf", " " + fixhasil.format(fixorf));
                    Descending.add(fixorf);

                    Double fixantraks = (HasilAntraks / totaldiagnosa) * 100.f;
                    Log.e("fix antraks", " " + fixhasil.format(fixantraks));
                    Descending.add(fixantraks);

                    Double fixkuku = (HasilKukuBusuk / totaldiagnosa) * 100.f;
                    Log.e("fix kuku busuk", " " + fixhasil.format(fixkuku));
                    Descending.add(fixkuku);

                    Double fixkeguguran = (HasilKeguguran / totaldiagnosa) * 100.f;
                    Log.e("fix keguguran", " " + fixhasil.format(fixkeguguran));
                    Descending.add(fixkeguguran);

                    //Sort array list into Ascending order = mengurutkan array dari terbesar ke terkecil

                    Collections.sort(Descending, Collections.<Double>reverseOrder());

                    //menampilkan 5 nilai terbesar


                    for (int i = 0; i < 5; i++) {

//                    Utilities.putPrefName("hasildiagnosa", "text" + 0, "" + Descending.get(i), getContext());

                        if (i < 2) {

                            if (Descending.get(i) == fixscabies) {

                                valuefix = String.valueOf(fixhasil.format(fixscabies));
                                penyakitfix = "Scabies";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixmastitis) {

                                valuefix = String.valueOf(fixhasil.format(fixmastitis));
                                penyakitfix = "Mastitis";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixpnemonia) {

                                valuefix = String.valueOf(fixhasil.format(fixpnemonia));
                                penyakitfix = "Pneumonia";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixhipo) {

                                valuefix = String.valueOf(fixhasil.format(fixhipo));
                                penyakitfix = "Hipokalsemia";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixpink) {

                                valuefix = String.valueOf(fixhasil.format(fixpink));
                                penyakitfix = "Pink eye";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixkembung) {

                                valuefix = String.valueOf(fixhasil.format(fixkembung));
                                penyakitfix = "Kembung";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixcacingan) {

                                valuefix = String.valueOf(fixhasil.format(fixcacingan));
                                penyakitfix = "Cacingan";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixorf) {


                                valuefix = String.valueOf(fixhasil.format(fixorf));
                                penyakitfix = "Orf";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixantraks) {

                                valuefix = String.valueOf(fixhasil.format(fixantraks));
                                penyakitfix = "Antraks";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixkuku) {

                                valuefix = String.valueOf(fixhasil.format(fixkuku));
                                penyakitfix = "Kuku busuk";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixkeguguran) {

                                valuefix = String.valueOf(fixhasil.format(fixkeguguran));
                                penyakitfix = "Keguguran";

//                            Log.e("cek", " " );

                            }

                        } else {

                            if (Descending.get(i) == fixscabies) {

                                valueprob = String.valueOf(fixhasil.format(fixscabies));
                                penyakitprob = "Scabies";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixmastitis) {

                                valueprob = String.valueOf(fixhasil.format(fixmastitis));
                                penyakitprob = "Mastitis";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixpnemonia) {

                                valueprob = String.valueOf(fixhasil.format(fixpnemonia));
                                penyakitprob = "Pneumonia";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixhipo) {

                                valueprob = String.valueOf(fixhasil.format(fixhipo));
                                penyakitprob = "Hipokalsemia";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixpink) {

                                valueprob = String.valueOf(fixhasil.format(fixpink));
                                penyakitprob = "Pink eye";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixkembung) {

                                valueprob = String.valueOf(fixhasil.format(fixkembung));
                                penyakitprob = "Kembung";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixcacingan) {

                                valueprob = String.valueOf(fixhasil.format(fixcacingan));
                                penyakitprob = "Cacingan";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixorf) {


                                valueprob = String.valueOf(fixhasil.format(fixorf));
                                penyakitprob = "Orf";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixantraks) {

                                valueprob = String.valueOf(fixhasil.format(fixantraks));
                                penyakitprob = "Antraks";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixkuku) {

                                valueprob = String.valueOf(fixhasil.format(fixkuku));
                                penyakitprob = "Kuku busuk";

//                            Log.e("cek", " " );

                            }

                            if (Descending.get(i) == fixkeguguran) {

                                valueprob = String.valueOf(fixhasil.format(fixkeguguran));
                                penyakitprob = "Keguguran";

//                            Log.e("cek", " " );

                            }

                        }

                        Log.e("Descending", " " + fixhasil.format(Descending.get(i)) + " no : " + i);
                        Log.e("penyakit prob", " " + penyakitprob + " no : " + i);
                        Log.e("nilai prob", " " + valueprob+ " no : " + i);
//                    Log.e("Descending", " " +Descending.get(i) + " no : " +i);

                        db.inserthasil(new DiagnosaHasilClassData(null, penyakitprob, valueprob));

                    }

                    Log.e("Penyakit Fix", " " + penyakitfix);
                    Log.e("Penyakit Fix", " " + valuefix);

                    String value = valuefix;
                    String penyakit = penyakitfix;

                    String penyakitpro = penyakitprob;
                    String valuepro = valueprob;

//                Log.e("Descending", " " +fixhasil.format(valuepro) + " no : ");

                    Bundle bundle = new Bundle();

                    bundle.putString("penyakit", penyakit);
                    bundle.putString("nilai", value);

                    bundle.putString("penyakitprob", penyakitpro);
                    bundle.putString("nilaiprob", valuepro);

                    fragment = new DiagnosaFragHasil();

                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

                }

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
