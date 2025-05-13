/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Aliaksei Bialiauski
 * SPDX-License-Identifier: MIT
 */
package org.sxl.parser;

import com.jcabi.matchers.XhtmlMatchers;
import java.io.IOException;
import org.cactoos.io.InputOf;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link SxlSyntax}.
 *
 * @since 0.0.0
 */
final class SxlSyntaxTest {

    @Test
    void parsesCanonicalExample() throws IOException {
        MatcherAssert.assertThat(
            "Parsed IR does not contains expected XPaths",
            new SxlSyntax(
                new InputOf(
                    String.join(
                        "\n",
                        "match \"/books\"",
                        "  <shelf>",
                        "    apply book"
                    )
                )
            ).parse(),
            XhtmlMatchers.hasXPaths(
                "/stylesheet/entry[1][contains(@xpath, '/books')]"
            )
        );
    }
}
