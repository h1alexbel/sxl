/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Aliaksei Bialiauski
 * SPDX-License-Identifier: MIT
 */
package org.sxl;

import com.jcabi.log.Logger;
import com.jcabi.xml.XSL;
import com.jcabi.xml.XSLDocument;

/**
 * SXL, the language.
 * @since 0.0.0
 */
public final class Sxl {

    public XSL toXsl(final String input) {
        Logger.info(this, "Boom!\nInput SXL:\n%s", input);
        return new XSLDocument(input);
    }
}
