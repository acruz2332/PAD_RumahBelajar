package com.pad1.padrumahbelajar.model;

import java.util.ArrayList;

public class QuestionResponse {

    private String status;
    private ArrayList<QuestionData> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<QuestionData> getData() {
        return data;
    }

    public void setData(ArrayList<QuestionData> data) {
        this.data = data;
    }
}