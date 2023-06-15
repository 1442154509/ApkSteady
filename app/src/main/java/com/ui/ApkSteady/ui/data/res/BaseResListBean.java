package com.ui.ApkSteady.ui.data.res;

import java.io.Serializable;
import java.util.List;

public class BaseResListBean<T> implements Serializable {
    private int code;
    private String msg;
    private List<T> data;
}
