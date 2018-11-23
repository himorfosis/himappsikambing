package com.dinaham.sikarbing;

public class ClassDataGejala {

    private String gejala;
    private String nilai;
    private boolean done;


    public ClassDataGejala (String gejala, String nilai){
        this.gejala = gejala;
        this.nilai = nilai;
    }

    public String getGejala(){
        return gejala;
    }

    public void setGejala(String gejala) {
        this.gejala = gejala;  }


    public String getNilai(){
        return nilai;

    }

    public void setNilai(String nilai) {
        this.nilai = nilai;

    }

    public boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
