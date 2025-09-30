package com.navigation.strategy;

import com.navigation.util.LoggerUtil;

public class ScenicRouteStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String source, String destination) {
        LoggerUtil.info("Calculating scenic route from " + source + " to " + destination);
    }
}
