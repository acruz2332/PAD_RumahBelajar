package com.pad1.padrumahbelajar.model;
import com.google.gson.annotations.SerializedName;

public class KelasData {

    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIkon() {
        return ikon;
    }

    public void setIkon(String ikon) {
        this.ikon = ikon;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    @SerializedName("ikon")
    private String ikon;

    @SerializedName("nama_kelas")
    private String namaKelas;
}
