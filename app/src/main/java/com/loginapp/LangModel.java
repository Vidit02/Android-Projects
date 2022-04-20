package com.loginapp;

public class LangModel {
    String strlang;
    int imglang;

    public LangModel(String strlang, int imglang) {
        this.strlang = strlang;
        this.imglang = imglang;
    }

    public String getStrlang() {
        return strlang;
    }

    public void setStrlang(String strlang) {
        this.strlang = strlang;
    }

    public int getImglang() {
        return imglang;
    }

    public void setImglang(int imglang) {
        this.imglang = imglang;
    }
}
