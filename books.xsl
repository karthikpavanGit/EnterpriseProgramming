<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/books">
        <html>
            <body>
                <h2>Books List</h2>
                <xsl:for-each select="book">
                    <div style="border: 1px solid black; margin: 10px; padding: 10px;">
                        <h3><xsl:value-of select="title"/></h3>
                        <p>Author: <xsl:value-of select="author"/></p>
                        <p>Price: $<xsl:value-of select="price"/></p>
                    </div>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

