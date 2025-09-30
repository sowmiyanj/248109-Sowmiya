package com.smartoffice.model;

import com.smartoffice.util.LoggerUtil;

public class AirConditioner implements Observer {
    @Override
    public void update(boolean occupied) {
        if (occupied) {
            LoggerUtil.info("AC ON - Room occupied");
        } else {
            LoggerUtil.info("AC OFF - Room empty");
        }
    }
}
