package com.pad1.padrumahbelajar.quiz;

import com.pad1.padrumahbelajar.model.KelasData;

import java.util.ArrayList;

public class HistoryResponse {

    private String status;
    private ArrayList<HistoryData> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<HistoryData> getData() {
        return data;
    }

    public void setData(ArrayList<HistoryData> data) {
        this.data = data;
    }
}
