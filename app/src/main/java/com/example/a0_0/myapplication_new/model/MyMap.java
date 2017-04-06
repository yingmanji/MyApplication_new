package com.example.a0_0.myapplication_new.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 樱满集0_0 on 2017/3/29.
 */

public class MyMap implements Serializable{
    private Map<String,String> map=new HashMap<>();

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
