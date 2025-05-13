/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Aliaksei Bialiauski
 * SPDX-License-Identifier: MIT
 */
package org.sxl.parser;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import java.io.IOException;
import java.util.List;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.cactoos.Input;
import org.cactoos.Text;
import org.cactoos.list.ListOf;
import org.cactoos.text.FormattedText;
import org.cactoos.text.Joined;
import org.cactoos.text.Split;
import org.cactoos.text.TextOf;
import org.sxl.SxlParser;
import org.xembly.Directives;
import org.xembly.Xembler;

/**
 * SXL syntax.
 * @since 0.0.0
 */
public final class SxlSyntax {

    /**
     * Text to parse.
     */
    private final Input input;

    /**
     * Ctor.
     * @param ipt Input
     */
    public SxlSyntax(final Input ipt) {
        this.input = ipt;
    }

    final XML parse() throws IOException {
        final SxlParser parser = new SxlParser(
            new CommonTokenStream(new SxlIndentLexer(this.normalize()))
        );
        final XeListener xel = new XeListener();
        new ParseTreeWalker().walk(xel, parser.stylesheet());
        final XML dom = new XMLDocument(
            new Xembler(
                new Directives(xel)
            ).domQuietly()
        );
        return dom;
    }

    /**
     * Normalize input to UNIX format to ensure that EOL exists at the
     * end of the text.
     *
     * @return UNIX formatted text.
     */
    private Text normalize() {
        return new FormattedText(
            "%s\n",
            new Joined(new TextOf("\n"), this.lines())
        );
    }

    /**
     * Split input into lines.
     * @return Lines without line breaks.
     */
    private List<Text> lines() {
        return new ListOf<>(new Split(new TextOf(this.input), "\r?\n"));
    }
}
