package com.pad1.padrumahbelajar.quiz;

import com.google.gson.annotations.SerializedName;

public class HistoryData {

    @SerializedName("token")
    private String tokenMurid;

    @SerializedName("nama")
    private String nama;

    @SerializedName("benar")
    private String benar;

    @SerializedName("salah")
    private String salah;

    @SerializedName("kosong")
    private String kosong;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBenar() {
        return benar;
    }

    public void setBenar(String benar) {
        this.benar = benar;
    }

    public String getSalah() {
        return salah;
    }

    public void setSalah(String salah) {
        this.salah = salah;
    }

    public String getKosong() {
        return kosong;
    }

    public void setKosong(String kosong) {
        this.kosong = kosong;
    }

    public String getPercobaanKe() {
        return percobaanKe;
    }

    public void setPercobaanKe(String percobaanKe) {
        this.percobaanKe = percobaanKe;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getTokenMurid() {
        return tokenMurid;
    }

    public void setTokenMurid(String tokenMurid) {
        this.tokenMurid = tokenMurid;
    }

    @SerializedName("percobaanKe")
    private String percobaanKe;

    @SerializedName("nilai")
    private String nilai;



}
