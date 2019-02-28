package org.appledash.expectations.expectors.type;

import org.appledash.expectations.expectors.Expector;

import java.util.Objects;

public class SimpleEqualityExpector<TInput, TArgument> extends Expector<TInput, TInput, TArgument> {
    @Override
    public boolean matches(TInput pattern, TInput input) {
        return Objects.equals(pattern, input);
    }
}
