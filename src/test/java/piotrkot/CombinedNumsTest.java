/*
 * The Closed-Source License
 *
 * Copyright (c) 2022 Fair-Kom.
 *
 * All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * The file is proprietary and confidential.
 */
package piotrkot;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Tests for {@link CombinedNums}.
 * @since 1.0
 * @checkstyle MagicNumber (100 lines)
 */
public final class CombinedNumsTest {
    @Test
    public void shouldFindOne() throws Exception {
        MatcherAssert.assertThat(
            new CombinedNums(3).findMax(),
            Matchers.is("3")
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotFindWithZero() throws Exception {
        new CombinedNums(0).findMax();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotFindNegative() throws Exception {
        new CombinedNums(-1).findMax();
    }

    @Test
    public void shouldFindCaseOne() throws Exception {
        MatcherAssert.assertThat(
            new CombinedNums(50, 2, 1, 9).findMax(),
            Matchers.is("95021")
        );
    }

    @Test
    public void shouldFindCaseTwo() throws Exception {
        MatcherAssert.assertThat(
            new CombinedNums(5, 50, 56).findMax(),
            Matchers.is("56550")
        );
    }

    @Test
    public void shouldFindCaseThree() throws Exception {
        MatcherAssert.assertThat(
            new CombinedNums(420, 42, 423).findMax(),
            Matchers.is("42423420")
        );
    }

    @Test
    public void shouldFindEqual() throws Exception {
        MatcherAssert.assertThat(
            new CombinedNums(1, 1).findMax(),
            Matchers.is("11")
        );
    }

    @Test
    public void shouldFindMaxInteger() throws Exception {
        MatcherAssert.assertThat(
            new CombinedNums(Integer.MAX_VALUE, 9).findMax(),
            Matchers.is("92147483647")
        );
    }
}
