# SXL - Simpler XML Transformation Language

**Motivation**. [XSLT] is a functional language for [XML] transformations. It
is widely used in [web development][XML-in-Browser], [ETL] pipelines, and even
in language design ([EO-to-Java compiler][EO] is written in XSLT). However, the
complexity of the language is often a barrier for programmers not familiar with
XML. Thats why we created a new language, with the same semantic as XSLT 3.0,
but with a simpler syntax, and user-friendly tooling.

## Quick Start

Consider this XML:

```xml
<books>
  <book author="Elliotte Rusty Harold">XML in a Nutshell</book>
  <book author="Steve McConnell">Code Complete</book>
</books>
```

In SXL, we might transform it like this:

```xml
match -> "/books"
  shelf
    apply-templates -> "book"

template -> "book"
  entry
    text()
    " by "
    @author
```

You should have this XML in the result:

```xml
<shelf>
  <entry>XML in a Nutshell by Elliotte Rusty Harold</entry>
  <entry>Code Complete by Steve McConnell</entry>
</shelf>
```

BTW, this is how XSLT stylesheet will look like to achieve the same:

```xsl
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
```

[XSLT]: https://en.wikipedia.org/wiki/XSLT
[XML]: https://en.wikipedia.org/wiki/XML
[ETL]: https://en.wikipedia.org/wiki/Extract,_transform,_load
[EO]: https://github.com/objectioanary/eo
[XML-in-Browser]: https://www.yegor256.com/2014/06/25/xml-and-xslt-in-browser.html
