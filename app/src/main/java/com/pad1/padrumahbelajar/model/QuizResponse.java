package com.pad1.padrumahbelajar.model;

import java.util.ArrayList;

public class QuizResponse {

    private String status;
    private ArrayList<QuizData> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<QuizData> getData() {
        return data;
    }

    public void setData(ArrayList<QuizData> data) {
        this.data = data;
    }
}

