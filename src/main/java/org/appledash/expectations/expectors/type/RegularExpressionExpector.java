package org.appledash.expectations.expectors.type;

import org.appledash.expectations.expectors.Expector;

import java.util.function.Consumer;
import java.util.regex.Pattern;

public class RegularExpressionExpector<TArgument> extends Expector<Pattern, String, TArgument> {
    public void expect(String pattern, Consumer<TArgument> action) {
        super.expect(Pattern.compile(pattern), action);
    }

    @Override
    public boolean matches(Pattern pattern, String input) {
        return pattern.matcher(input).find();
    }
}
