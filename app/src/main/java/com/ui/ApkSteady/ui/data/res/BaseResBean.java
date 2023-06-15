package com.ui.ApkSteady.ui.data.res;

import java.io.Serializable;
import java.util.List;

public class BaseResBean<T> implements Serializable {
    private int code;
    private String msg;
    private T data;
}
