package org.appledash.expectations.tests;

import org.appledash.expectations.expectors.type.RegularExpressionExpector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegularExpressionExpectorTest {
    private RegularExpressionExpector<Integer> expector;

    @BeforeEach
    public void initializeExpector() {
        this.expector = new RegularExpressionExpector<>();
    }

    @Test
    public void testExpector() {
        int[] output = { 0 };

        this.expector.expect("^[0-9]{3}$", data -> {
            output[0] = data;
        });

        this.expector.feed("abc", 1);

        Assertions.assertEquals(0, output[0], "non-matching input should not run anything");

        this.expector.feed("123", 1);

        Assertions.assertEquals(1, output[0], "matching input should run action");
    }
}
