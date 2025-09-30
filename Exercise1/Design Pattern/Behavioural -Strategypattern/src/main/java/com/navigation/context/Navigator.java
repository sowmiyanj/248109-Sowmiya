package com.navigation.context;

import com.navigation.strategy.RouteStrategy;

public class Navigator {
    private RouteStrategy strategy;

    public void setRouteStrategy(RouteStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Route strategy cannot be null");
        }
        this.strategy = strategy;
    }

    public void buildRoute(String source, String destination) {
        if (strategy == null) {
            throw new IllegalStateException("No route strategy selected");
        }
        if (source == null || source.trim().isEmpty() || destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException("Source and Destination must be provided");
        }
        strategy.buildRoute(source, destination);
    }
}
