<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" indent="yes" encoding="UTF-8"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Checkstyle Report</title>
            </head>
            <body>
                <h1>Checkstyle Violations</h1>
                <xsl:for-each select="checkstyle/file">
                    <h2><xsl:value-of select="@name"/></h2>
                    <table border="1">
                        <tr bgcolor="#cccccc">
                            <th>Line</th>
                            <th>Severity</th>
                            <th>Message</th>
                        </tr>
                        <xsl:for-each select="error">
                            <tr>
                                <td><xsl:value-of select="@line"/></td>
                                <td><xsl:value-of select="@severity"/></td>
                                <td><xsl:value-of select="@message"/></td>
                            </tr>
                        </xsl:for-each>
                    </table>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
