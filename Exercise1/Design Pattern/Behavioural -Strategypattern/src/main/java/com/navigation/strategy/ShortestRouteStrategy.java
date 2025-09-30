package com.navigation.strategy;

import com.navigation.util.LoggerUtil;

public class ShortestRouteStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String source, String destination) {
        LoggerUtil.info("Calculating shortest route from " + source + " to " + destination);
    }
}
