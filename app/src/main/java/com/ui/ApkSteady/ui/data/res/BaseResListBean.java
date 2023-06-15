package com.ui.ApkSteady.ui.data.res;

import java.io.Serializable;
import java.util.List;

public class BaseResListBean<T> implements Serializable {
    public int code;
    public String msg;
    public List<T> data;
}
