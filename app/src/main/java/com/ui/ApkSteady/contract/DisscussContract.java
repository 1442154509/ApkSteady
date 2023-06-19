package com.ui.ApkSteady.contract;

import baselibs.mvp.IModel;
import baselibs.mvp.IView;

public interface DisscussContract {
    interface DisscussModel extends IModel {

    }

    interface DisscussView extends IView {
        void updataUI();
    }
}
