package com.varackova.transparentaccounts.rest;

import com.squareup.otto.Bus;

/**
 * Provider for Bus instances
 */
public class BusProvider {

    private static final Bus BUS = new MainThreadBus();

    public static Bus getInstance() {
        return BUS;
    }
}
