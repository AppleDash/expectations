package org.appledash.expectations.impl;

import java.util.function.Consumer;

public class Expectation<TPattern, TAction> {
    private final TPattern pattern;
    private final Consumer<TAction> action;

    public Expectation(TPattern pattern, Consumer<TAction> action) {
        this.pattern = pattern;
        this.action = action;
    }

    public TPattern getPattern() {
        return this.pattern;
    }

    public Consumer<TAction> getAction() {
        return this.action;
    }
}
