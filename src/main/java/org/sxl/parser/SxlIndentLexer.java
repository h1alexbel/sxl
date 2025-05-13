/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Aliaksei Bialiauski
 * SPDX-License-Identifier: MIT
 */
package org.sxl.parser;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.cactoos.Text;
import org.cactoos.io.InputStreamOf;
import org.sxl.SxlLexer;

/**
 * Indentation-aware lexer.
 * @since 0.0.0
 */
final class SxlIndentLexer extends SxlLexer {

    /**
     * Ctor.
     * @param txt Source code.
     * @throws IOException If fails.
     */
    SxlIndentLexer(final Text txt) throws IOException {
        this(CharStreams.fromStream(new InputStreamOf(txt)));
    }

    /**
     * Ctor.
     * @param input Input
     */
    SxlIndentLexer(final CharStream input) {
        super(input);
    }
}
