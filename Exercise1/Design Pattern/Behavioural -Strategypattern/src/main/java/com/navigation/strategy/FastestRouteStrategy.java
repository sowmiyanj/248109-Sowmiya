package com.navigation.strategy;

import com.navigation.util.LoggerUtil;

public class FastestRouteStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String source, String destination) {
        LoggerUtil.info("Calculating fastest route from " + source + " to " + destination);
    }
}
