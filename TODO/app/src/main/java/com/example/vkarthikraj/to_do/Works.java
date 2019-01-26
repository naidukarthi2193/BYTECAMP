package com.example.vkarthikraj.to_do;

import android.content.Intent;

import java.util.ArrayList;

public class Works implements java.io.Serializable {

    public String getWorks() {
        return works;
    }

    public int getPriority() {
        return priority;
    }

    private String works;
    private int priority;


    public Works(String works, int priority) {
        this.works = works;
        this.priority = priority;
    }

}
