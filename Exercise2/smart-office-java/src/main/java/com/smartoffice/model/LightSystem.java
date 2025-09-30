package com.smartoffice.model;

import com.smartoffice.util.LoggerUtil;

public class LightSystem implements Observer {
    @Override
    public void update(boolean occupied) {
        if (occupied) {
            LoggerUtil.info("Lights ON - Room occupied");
        } else {
            LoggerUtil.info("Lights OFF - Room empty");
        }
    }
}
