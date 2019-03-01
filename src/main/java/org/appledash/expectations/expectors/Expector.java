package org.appledash.expectations.expectors;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class Expector<TPattern, TInput, TArgument> {
    private final List<Expectation<TPattern, TArgument>> expectations = new ArrayList<>();

    public void expect(TPattern pattern, Consumer<TArgument> action) {
        this.expectations.add(new Expectation<>(pattern, action));
    }

    public void feed(TInput input, TArgument argument) {
        for (Expectation<TPattern, TArgument> expectation : this.expectations) {
            if (this.matches(expectation.getPattern(), input)) {
                expectation.getAction().accept(argument);
            }
        }
    }

    public abstract boolean matches(TPattern pattern, TInput input);

    private static class Expectation<TPattern, TAction> {
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
}
