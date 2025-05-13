/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Aliaksei Bialiauski
 * SPDX-License-Identifier: MIT
 */
package org.sxl;

import com.jcabi.xml.XSLDocument;
import org.cactoos.io.ResourceOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link Sxl}.
 *
 * @since 0.0.0
 * @todo #1:90min Enable canonical test after transpilation to XSLT will be implemented.
 *  We should enable the test, right after we implement the transpiler.
 */
final class SxlTest {

    @Disabled
    @Test
    void transformsCanonical() throws Exception {
        MatcherAssert.assertThat(
            "The output XSL does not match with expected",
            new Sxl().toXsl(
                String.join(
                    "\n",
                    "match -> \"/books\"",
                    "  shelf",
                    "    apply -> \"book\"",
                    "",
                    "template -> \"book\"",
                    "  entry",
                    "    text()",
                    "    \" by \"",
                    "    @author"
                )
            ),
            Matchers.equalTo(
                new XSLDocument(
                    new ResourceOf(
                        "org/sxl/canonical.xsl"
                    ).stream()
                )
            )
        );
    }
}
