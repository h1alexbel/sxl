<?xml version="1.0" encoding="UTF-8"?>
<!--
 * SPDX-FileCopyrightText: Copyright (c) 2025 Aliaksei Bialiauski
 * SPDX-License-Identifier: MIT
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="3.0">
  <xsl:output method="xml"/>
  <xsl:template match="/books">
    <shelf>
      <xsl:apply-templates select="book"/>
    </shelf>
  </xsl:template>
  <xsl:template match="book">
    <entry>
      <xsl:value-of select="text()"/>
      <xsl:text> by </xsl:text>
      <xsl:value-of select="@author"/>
    </entry>
  </xsl:template>
</xsl:stylesheet>
