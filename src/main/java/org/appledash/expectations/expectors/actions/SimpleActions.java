package org.appledash.expectations.expectors.actions;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;

public final class SimpleActions {
    public static <T> Consumer<T> chain(Consumer<T>... actions) {
        return chain(Arrays.asList(actions));
    }

    public static <T> Consumer<T> chain(Collection<Consumer<T>> actions) {
        return data -> {
            for (Consumer<T> consumer : actions) {
                consumer.accept(data);
            }
        };
    }
}
