/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Aliaksei Bialiauski
 * SPDX-License-Identifier: MIT
 */
package org.sxl.parser;

import java.util.Iterator;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.sxl.SxlListener;
import org.sxl.SxlParser;
import org.xembly.Directive;
import org.xembly.Directives;

/**
 * SXL Xembly AST listener.
 *
 * @since 0.0.0
 */
final class XeListener implements SxlListener, Iterable<Directive> {

    /**
     * Xembly directives.
     */
    private final Directives dirs;

    /**
     * Ctor.
     */
    XeListener() {
        this.dirs = new Directives();
    }

    @Override
    public Iterator<Directive> iterator() {
        return this.dirs.iterator();
    }

    @Override
    public void enterStylesheet(final SxlParser.StylesheetContext ctx) {
        this.dirs.add("stylesheet");
    }

    @Override
    public void exitStylesheet(final SxlParser.StylesheetContext ctx) {
        this.dirs.up();
    }

    @Override
    public void enterEntry(final SxlParser.EntryContext ctx) {
    }

    @Override
    public void exitEntry(final SxlParser.EntryContext ctx) {
    }

    @Override
    public void enterMatch(final SxlParser.MatchContext ctx) {
        this.dirs.add("entry").attr("xpath", ctx.XPATH().getText())
            .xpath("/templates");
    }

    @Override
    public void exitMatch(final SxlParser.MatchContext ctx) {
        this.dirs.up();
    }

    @Override
    public void enterTemplate(final SxlParser.TemplateContext ctx) {
        this.dirs.add("template").attr("name", ctx.tid().getText());
    }

    @Override
    public void exitTemplate(final SxlParser.TemplateContext ctx) {
        this.dirs.up();
    }

    @Override
    public void enterApplication(final SxlParser.ApplicationContext ctx) {
        this.dirs.add("application");
    }

    @Override
    public void exitApplication(final SxlParser.ApplicationContext ctx) {
    }

    @Override
    public void enterTid(final SxlParser.TidContext ctx) {
        final Directives template = this.dirs.add("template").attr("name", ctx.NAME().getText());
        if (ctx.tmode() != null) {
            template.attr("mode", ctx.tmode().NAME().getText());
        }
    }

    @Override
    public void exitTid(final SxlParser.TidContext ctx) {
    }

    @Override
    public void enterNodename(final SxlParser.NodenameContext ctx) {
        this.dirs.add("node").attr("name", ctx.NAME().getText());
    }

    @Override
    public void exitNodename(final SxlParser.NodenameContext ctx) {
        this.dirs.up();
    }

    @Override
    public void enterXattr(final SxlParser.XattrContext ctx) {
        throw new UnsupportedOperationException("#enterXattr()");
    }

    @Override
    public void exitXattr(final SxlParser.XattrContext ctx) {
        throw new UnsupportedOperationException("#exitXattr()");
    }

    @Override
    public void enterTmode(final SxlParser.TmodeContext ctx) {
        throw new UnsupportedOperationException("#enterTmode()");
    }

    @Override
    public void exitTmode(final SxlParser.TmodeContext ctx) {
        throw new UnsupportedOperationException("#exitTmode()");
    }

    @Override
    public void visitTerminal(final TerminalNode terminalNode) {
        // This method is created by ANTLR and can't be removed
    }

    @Override
    public void visitErrorNode(final ErrorNode errorNode) {
        // This method is created by ANTLR and can't be removed
    }

    @Override
    public void enterEveryRule(final ParserRuleContext parserRuleContext) {
        // This method is created by ANTLR and can't be removed
    }

    @Override
    public void exitEveryRule(final ParserRuleContext parserRuleContext) {
        // This method is created by ANTLR and can't be removed
    }
}
