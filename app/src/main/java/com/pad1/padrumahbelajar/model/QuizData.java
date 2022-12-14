package com.pad1.padrumahbelajar.model;


import com.google.gson.annotations.SerializedName;

public class QuizData {

    @SerializedName("token")
    private String token;

    @SerializedName("mata_pelajaran")
    private String mataPelajaran;

    @SerializedName("nama_quiz")
    private String namaQuiz;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMataPelajaran() {
        return mataPelajaran;
    }

    public void setMataPelajaran(String mataPelajaran) {
        this.mataPelajaran = mataPelajaran;
    }

    public String getNamaQuiz() {
        return namaQuiz;
    }

    public void setNamaQuiz(String namaQuiz) {
        this.namaQuiz = namaQuiz;
    }
}
