package com.dinaham.sikarbing;

/**
 * Created by him on 5/14/2018.
 */

public class DiagnosaHasilClassData {

    Integer id_hasil;
    private String penyakit;
    private String nilai;


    public DiagnosaHasilClassData (Integer id_hasil, String penyakit, String nilai){
        this.id_hasil = id_hasil;
        this.penyakit = penyakit;
        this.nilai = nilai;
    }

    public Integer getId_hasil() {
        return id_hasil;
    }

    public String getHasilPenyakit() {
        return penyakit;

    }

    public String getHasilNilai() {
        return nilai;
    }


}
