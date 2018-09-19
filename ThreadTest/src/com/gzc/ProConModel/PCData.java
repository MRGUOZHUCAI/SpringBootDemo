package com.gzc.ProConModel;

public class PCData {
    private final int intData;

    public  PCData(int d){
       this.intData = d;
    }

    public  PCData(String d){
        this.intData = Integer.valueOf(d);
    }

    public int getIntData() {
        return intData;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "intData=" + intData +
                '}';
    }
}

