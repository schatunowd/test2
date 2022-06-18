<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
  <xsl:template match="table">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
      <fo:layout-master-set>
        <fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm" margin-top="2cm" margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
          <fo:region-body/>
        </fo:simple-page-master>
      </fo:layout-master-set>
      <fo:page-sequence master-reference="simpleA4">
        <fo:flow flow-name="xsl-region-body">
          <fo:block font-size="10pt">
          <fo:table table-layout="fixed" width="100%" border-collapse="separate">    
            <fo:table-column column-width="4cm"/>
            <fo:table-column column-width="4cm"/>
            <fo:table-column column-width="4cm"/>
	        <fo:table-column column-width="4cm"/>
			<fo:table-column column-width="4cm"/>
			
			<fo:table-header>
				<fo:table-cell>
					<fo:block font-weight="bold">id_person</fo:block>
				</fo:table-cell>
				<fo:table-cell>
					<fo:block font-weight="bold">name</fo:block>
				</fo:table-cell>
				<fo:table-cell>
					<fo:block font-weight="bold">surname</fo:block>
				</fo:table-cell>
				<fo:table-cell>
					<fo:block font-weight="bold">patronymic</fo:block>
				</fo:table-cell>
				<fo:table-cell>
					<fo:block font-weight="bold">position</fo:block>
				</fo:table-cell>
			</fo:table-header>
			
            <fo:table-body>
              <xsl:apply-templates select="row"/>
            </fo:table-body>
          </fo:table>
          </fo:block>
        </fo:flow>
      </fo:page-sequence>
    </fo:root>
  </xsl:template>
  <xsl:template match="row">
    <fo:table-row>   
      <fo:table-cell>
        <fo:block>
          <xsl:value-of select="id_person"/>
        </fo:block>
      </fo:table-cell>
      <fo:table-cell>
        <fo:block>
          <xsl:value-of select="name"/>
        </fo:block>
      </fo:table-cell>   
      <fo:table-cell>
        <fo:block>
      <xsl:value-of select="surname"/>
        </fo:block>
      </fo:table-cell>
	  <fo:table-cell>
        <fo:block>
      <xsl:value-of select="patronymic"/>
        </fo:block>
      </fo:table-cell>
	  <fo:table-cell>
        <fo:block>
      <xsl:value-of select="position"/>
        </fo:block>
      </fo:table-cell>
    </fo:table-row>
  </xsl:template>
</xsl:stylesheet>