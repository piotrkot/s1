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

import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.cactoos.iterable.Mapped;
import org.cactoos.iterable.Sorted;
import org.cactoos.list.ListOf;
import org.cactoos.text.Joined;

/**
 * Combined numbers.
 *
 * @since 1.0
 */
@RequiredArgsConstructor
public final class CombinedNums {
    /**
     * List of numbers.
     */
    private final Iterable<Num> nums;

    /**
     * Constructor.
     * @param nums List of numbers
     */
    public CombinedNums(final List<Integer> nums) {
        this(
            new Mapped<>(
                Num::new,
                nums
            )
        );
    }

    /**
     * Constructor.
     * @param nums Array of numbers
     */
    public CombinedNums(final Integer... nums) {
        this(
            new ListOf<>(nums)
        );
    }

    /**
     * Find maximum number as the best concatenation of numbers.
     * @return Number as a string
     * @throws Exception When fails
     */
    public String findMax() throws Exception {
        return new Joined(
            "",
            new Mapped<>(
                elem -> elem.value,
                new Sorted<>(this.nums)
            )
        ).asString();
    }

    /**
     * Comparable string number. Only positive numbers allowed.
     * @since 1.0
     */
    private static final class Num implements Comparable<Num> {
        /**
         * String value for the number.
         */
        private final String value;

        /**
         * Constructor.
         * @param num Positive integer number
         * @throws IllegalArgumentException When integer is negative or zero
         */
        @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
        Num(final Integer num) {
            if (num <= 0) {
                throw new IllegalArgumentException("Negative values or zero not allowed!");
            }
            this.value = num.toString();
        }

        @Override
        public int compareTo(final Num num) {
            return (num.value + this.value).compareTo(this.value + num.value);
        }

        @Override
        public boolean equals(final Object obj) {
            final boolean result;
            if (obj == null || getClass() != obj.getClass()) {
                result = false;
            } else {
                result = this.compareTo((Num) obj) == 0;
            }
            return result;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }
    }
}
