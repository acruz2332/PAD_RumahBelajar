package com.pad1.padrumahbelajar.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class QuestionData {

    @SerializedName("question")
    private String question;

    @SerializedName("answer")
    private ArrayList<String> answer;

    @SerializedName("jawaban")
    private String jawaban;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<String> answer) {
        this.answer = answer;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }


}