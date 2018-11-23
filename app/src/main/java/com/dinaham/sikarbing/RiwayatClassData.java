package com.dinaham.sikarbing;

/**
 * Created by him on 5/13/2018.
 */

public class RiwayatClassData {

    Integer id_riwayat;
    private String penyakit;
    private String tanggal;
    private String nilai;

    RiwayatClassData(Integer id_riwayat, String penyakit, String tanggal, String nilai) {

        this.id_riwayat = id_riwayat;
        this.penyakit = penyakit;
        this.tanggal = tanggal;
        this.nilai = nilai;

    }

    public Integer getId_riwayar() {
        return id_riwayat;
    }

    public String getPenyakit() {
        return penyakit;

    }

    public String getTanggal() {
        return tanggal;

    }

    public String getNilai() {
        return nilai;
    }



}
