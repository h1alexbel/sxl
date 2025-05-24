/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Aliaksei Bialiauski
 * SPDX-License-Identifier: MIT
 */
package org.sxl.parser;

import org.eolang.jucs.ClasspathSource;
import org.eolang.xax.XtSticky;
import org.eolang.xax.XtYaml;
import org.eolang.xax.XtoryMatcher;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.params.ParameterizedTest;

/**
 * Tests for {@link SxlSyntax}.
 *
 * @since 0.0.0
 */
final class SxlSyntaxTest {

    @ParameterizedTest
    @ClasspathSource(value = "org/sxl/sxl-packs/parse", glob = "**.yaml")
    void parsesSyntax(final String yaml) {
        MatcherAssert.assertThat(
            "Story failures are not empty, but they should",
            new XtSticky(
                new XtYaml(
                    yaml,
                    sxl -> new SxlSyntax(sxl).parsed()
                )
            ),
            new XtoryMatcher()
        );
    }
}
