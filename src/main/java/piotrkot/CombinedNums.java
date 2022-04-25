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

import lombok.RequiredArgsConstructor;
import org.cactoos.iterable.Mapped;
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
    private final Iterable<Integer> nums;

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
                Object::toString,
                this.nums
            )
        ).asString();
    }
}
