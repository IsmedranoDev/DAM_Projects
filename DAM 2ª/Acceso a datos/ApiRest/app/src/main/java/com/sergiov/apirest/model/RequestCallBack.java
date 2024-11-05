package com.sergiov.apirest.model;

public interface RequestCallBack {
    void onSuccess(String response,String tipo);
    void onError(String error);

}