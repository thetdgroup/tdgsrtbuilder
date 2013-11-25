<?xml version="1.0"?>
<xsl:stylesheet version="1.0" 
                xmlns:tdg="urn:com:thetdgroup:schema:tdg_srt:v1" 
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
                xsi:schemaLocation="urn:com:thetdgroup:schema:ompc:v01 TDG_SRT-v1.0.xsd" 
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

 <xsl:output method="xml" omit-xml-declaration="yes" encoding="UTF-8" indent="yes"/>

 <!-- -->
 <xsl:template match="/">
  <add>
   <xsl:apply-templates select="//tdg:TDG_SRT_Corpus"/>
  </add>
 </xsl:template>

 <!-- Parallel Corpus (Segments) -->
 <xsl:template match="//tdg:TDG_SRT_Corpus">
  <doc>
   <xsl:apply-templates/>
  </doc>
 </xsl:template>

 <xsl:template match="//tdg:CorpusBody//tdg:CorpusSearchText//tdg:SearchText">
  <xsl:variable name="language_iso" select="@tdg:Language"/>

  <!-- This will select, based on the language, the right Analyzer to use -->
  <!-- for example, if the iso is acm (Iraqi) we mark the analyzer as ara (Arabic analyzer) -->
  <xsl:choose>
   <!-- Arabic Section -->
   <xsl:when test="$language_iso='ara'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='acm'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='arq'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='aao'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='bbz'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='abv'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='shu'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='acy'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='adf'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='avl'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='arz'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='afb'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='ayh'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='acw'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='ayl'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='ary'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='ars'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='apc'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='ayp'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='acx'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='aec'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='ayn'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='ssh'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='ajp'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='arb'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='apd'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='pga'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='acq'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='abh'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='pga'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='aeb'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='auz'">
    <field name="ara">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>

   <!-- Chinese Section -->
   <xsl:when test="$language_iso='zho'">
    <field name="chi">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='gan'">
    <field name="chi">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='hak'">
    <field name="chi">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='czh'">
    <field name="chi">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='cjy'">
    <field name="chi">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='lzh'">
    <field name="chi">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='cmn'">
    <field name="chi">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='mnp'">
    <field name="chi">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='cdo'">
    <field name="chi">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='nan'">
    <field name="chi">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='czo'">
    <field name="chi">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='cpx'">
    <field name="chi">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='wuu'">
    <field name="chi">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='hsn'">
    <field name="chi">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>
   <xsl:when test="$language_iso='yue'">
    <field name="chi">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:when>

   <!-- anything other Languages else not covered -->
   <xsl:otherwise>
    <field name="{$language_iso}">
     <xsl:value-of select="tdg:Text/text()"/>
    </field>
   </xsl:otherwise>
  </xsl:choose>

  <!-- Here we add a Language tag that represents the real language name 
  (not the choosen Analyzer) -->
  <!--<field name="language">
   <xsl:if test="$language_iso='ara'">Arabic</xsl:if>
   <xsl:if test="$language_iso='arq'">Algerian Arabic</xsl:if>
   <xsl:if test="$language_iso='aao'">Algerian Saharan Arabic</xsl:if>
   <xsl:if test="$language_iso='bbz'">Babalia Creole Arabic</xsl:if>
   <xsl:if test="$language_iso='abv'">Baharna Arabic</xsl:if>
   <xsl:if test="$language_iso='shu'">Chadian Arabic</xsl:if>
   <xsl:if test="$language_iso='acy'">Cypriot Arabic</xsl:if>
   <xsl:if test="$language_iso='adf'">Dhofari Arabi</xsl:if>
   <xsl:if test="$language_iso='avl'">Eastern Egyptian Bedawi Arabic</xsl:if>
   <xsl:if test="$language_iso='arz'">Egyptian Arabic</xsl:if>
   <xsl:if test="$language_iso='afb'">Gulf Arabic</xsl:if>
   <xsl:if test="$language_iso='ayh'">Hadrami Arabic</xsl:if>
   <xsl:if test="$language_iso='acw'">Hijazi Arabic</xsl:if>
   <xsl:if test="$language_iso='ayl'">Libyan Arabic</xsl:if>
   <xsl:if test="$language_iso='acm'">Mesopotamian Arabic</xsl:if>
   <xsl:if test="$language_iso='ary'">Moroccan Arabic</xsl:if>
   <xsl:if test="$language_iso='ars'">Najdi Arabic</xsl:if>
   <xsl:if test="$language_iso='apc'">North Levantine Arabic</xsl:if>
   <xsl:if test="$language_iso='ayp'">North Mesopotamian Arabic</xsl:if>
   <xsl:if test="$language_iso='acx'">Omani Arabic</xsl:if>
   <xsl:if test="$language_iso='aec'">Saidi Arabic</xsl:if>
   <xsl:if test="$language_iso='ayn'">Sanaani Arabic</xsl:if>
   <xsl:if test="$language_iso='ssh'">Shihhi Arabic</xsl:if>
   <xsl:if test="$language_iso='ajp'">South Levantine Arabic</xsl:if>
   <xsl:if test="$language_iso='arb'">Standard Arabic</xsl:if>
   <xsl:if test="$language_iso='apd'">Sudanese Arabic</xsl:if>
   <xsl:if test="$language_iso='pga'">Sudanese Creole Arabic</xsl:if>
   <xsl:if test="$language_iso='acq'">Ta'izzi-Adeni Arabic</xsl:if>
   <xsl:if test="$language_iso='abh'">Tajiki Arabic</xsl:if>
   <xsl:if test="$language_iso='aeb'">Tunisian Arabic</xsl:if>
   <xsl:if test="$language_iso='auz'">Uzbeki Arabic</xsl:if>
   <xsl:if test="$language_iso='chi'">Chinese</xsl:if>
   <xsl:if test="$language_iso='zho'">Chinese</xsl:if>
   <xsl:if test="$language_iso='gan'">Gan Chinese</xsl:if>
   <xsl:if test="$language_iso='hak'">Hakka Chinese</xsl:if>
   <xsl:if test="$language_iso='czh'">Huizhou Chinese</xsl:if>
   <xsl:if test="$language_iso='cjy'">Jinyu Chinese</xsl:if>
   <xsl:if test="$language_iso='lzh'">Literary Chinese</xsl:if>
   <xsl:if test="$language_iso='cmn'">Mandarin Chinese</xsl:if>
   <xsl:if test="$language_iso='mnp'">Min Bei Chinese</xsl:if>
   <xsl:if test="$language_iso='cdo'">Min Dong Chinese</xsl:if>
   <xsl:if test="$language_iso='nan'">Min Nan Chinese</xsl:if>
   <xsl:if test="$language_iso='czo'">Min Zhong Chinese</xsl:if>
   <xsl:if test="$language_iso='cpx'">Pu-Xian Chinese</xsl:if>
   <xsl:if test="$language_iso='wuu'">Wu Chinese</xsl:if>
   <xsl:if test="$language_iso='hsn'">Xiang Chinese</xsl:if>
   <xsl:if test="$language_iso='yue'">Yue Chinese</xsl:if>
   <xsl:if test="$language_iso='ace'">Achinese</xsl:if>
   <xsl:if test="$language_iso='eng'">English</xsl:if>
   <xsl:if test="$language_iso='fre'">French</xsl:if>
   <xsl:if test="$language_iso='deu'">German</xsl:if>
   <xsl:if test="$language_iso='ind'">Indonesian</xsl:if>
   <xsl:if test="$language_iso='pes'">Persian</xsl:if>
   <xsl:if test="$language_iso='rus'">Russian</xsl:if>
   <xsl:if test="$language_iso='sin'">Sinhala</xsl:if>
   <xsl:if test="$language_iso='spa'">Spanish</xsl:if>
   <xsl:if test="$language_iso='tam'">Tamil</xsl:if>
   <xsl:if test="$language_iso='kor'">Korean</xsl:if>
  </field>-->
 </xsl:template>

 <!-- -->
 <!-- Content Information -->
 <!-- -->
 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Project//tdg:ProjectTitle">
  <xsl:if test="string-length() &gt; 0">
   <field name="title">
    <xsl:value-of select="text()"/>
   </field>
  </xsl:if>
 </xsl:template>

 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Content//tdg:Alternate_Title">
  <xsl:if test="string-length() &gt; 0">
   <field name="alternate_title">
    <xsl:value-of select="text()"/>
   </field>
  </xsl:if>
 </xsl:template>

 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Content//tdg:Subjects">
  <xsl:for-each select="tdg:Subject">
   <field name="subject">
    <xsl:value-of select="@tdg:Text"/>
   </field>
  </xsl:for-each>  
 </xsl:template>

 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Content//tdg:Genres">
  <xsl:for-each select="tdg:Genre">
   <field name="genre">
    <xsl:value-of select="@tdg:Text"/>
   </field>
  </xsl:for-each>
 </xsl:template>
 
 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Content//tdg:Data_Quality">
  <xsl:if test="string-length() &gt; 0">
   <field name="corpus_quality">
    <xsl:value-of select="text()"/>
   </field>
  </xsl:if>
 </xsl:template> 

 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Content//tdg:Temporal_Coverages">
  <xsl:for-each select="tdg:Temporal_Coverage">
   <field name="start_date">
    <xsl:value-of select="@tdg:Start_Date"/>
   </field>
   <field name="end_date">
    <xsl:value-of select="@tdg:End_Date"/>
   </field>
  </xsl:for-each>
 </xsl:template>
 
 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Content//tdg:Corpus_Completed">
 </xsl:template>  

 <!--                -->
 <!-- NAMED ENTITIES -->
 <!--                -->
 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:NamedEntities">
  <xsl:for-each select="tdg:Anniversary">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>
  
   <field id="{$id}" name="anniversary">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>
  
  <xsl:for-each select="tdg:City">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="city">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>  
  
  <xsl:for-each select="tdg:Company">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="company">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>    
  
  <xsl:for-each select="tdg:Continent">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="continent">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>    
 
  <xsl:for-each select="tdg:Country">  
    <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>
  
   <field id="{$id}" name="country">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>   
 
  <xsl:for-each select="tdg:Currency">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="currency">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>  
  
  <xsl:for-each select="tdg:EmailAddress">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="email_address">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>   

  <xsl:for-each select="tdg:Facility">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="facility">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>  
  
  <xsl:for-each select="tdg:FaxNumber">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="fax_number">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each> 
    
  <xsl:for-each select="tdg:Holiday">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="holiday">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>   
  
  <xsl:for-each select="tdg:IndustryTerm">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="industry_term">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each> 
  
  <xsl:for-each select="tdg:MarketIndex">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="market_index">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>   
    
  <xsl:for-each select="tdg:MedicalCondition">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="medical_condition">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>   
     
  <xsl:for-each select="tdg:MedicalTreatment">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="medical_treatment">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each> 
     
  <xsl:for-each select="tdg:NaturalFeature">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="natural_feature">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>   
     
  <xsl:for-each select="tdg:Organization">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="organization">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>      
      
  <xsl:for-each select="tdg:Person">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="person">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each> 
       
  <xsl:for-each select="tdg:PhoneNumber">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="phone_number">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>  
        
  <xsl:for-each select="tdg:PoliticalEvent">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="political_event">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>   
        
  <xsl:for-each select="tdg:Position">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="position">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>    
         
  <xsl:for-each select="tdg:Product">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="product">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>  
         
  <xsl:for-each select="tdg:ProvinceOrState">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="province_or_state">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>    
         
  <xsl:for-each select="tdg:PublishedMedium">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="published_medium">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>     
          
  <xsl:for-each select="tdg:Region">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="region">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>   
          
  <xsl:for-each select="tdg:Technology">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="technology">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>    
  
  <xsl:for-each select="tdg:TVShow">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="tv_show">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each> 
   
  <xsl:for-each select="tdg:TVStation">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="tv_station">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each>    
  
  <xsl:for-each select="tdg:URL">
   <xsl:variable name="id" select="@tdg:entityID"></xsl:variable>

   <field id="{$id}" name="url">
    <xsl:value-of select="@tdg:entityName"/>
   </field>
  </xsl:for-each> 

 </xsl:template>
 
 
 <!-- -->
 <!-- Responsibility -->
 <!-- -->
 

 <!-- -->
 <!-- Linguistic -->
 <!-- --> 
 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Linguistic//tdg:Corpus_Type">
  <xsl:if test="string-length() &gt; 0">
   <field name="corpus_type">
    <xsl:value-of select="text()"/>
   </field>
  </xsl:if>
 </xsl:template>

 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Linguistic//tdg:Alignment">
  <xsl:if test="string-length() &gt; 0">
   <field name="alignment">
    <xsl:value-of select="text()"/>
   </field>
  </xsl:if>
 </xsl:template>
 
 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Linguistic//tdg:Source_Languages">
  <xsl:for-each select="tdg:Language/tdg:language_name">
   <xsl:if test="string-length() &gt; 0">
    <field name="language">
     <xsl:value-of select="text()"/>
    </field>
   </xsl:if>
  </xsl:for-each>
 </xsl:template>

 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Linguistic//tdg:Target_Languages">
  <xsl:for-each select="tdg:Language/tdg:language_name">
   <xsl:if test="string-length() &gt; 0">
    <field name="language">
     <xsl:value-of select="text()"/>
    </field>
   </xsl:if>
  </xsl:for-each>
 </xsl:template>
  
 <!-- -->
 <!-- Format -->
 <!-- --> 
 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Format//tdg:Data_Type">
  <xsl:if test="string-length() &gt; 0">
   <field name="data_type">
    <xsl:value-of select="text()"/>
   </field>
  </xsl:if>
 </xsl:template> 
 
 <!-- -->
 <!-- Administrative -->
 <!-- --> 

 <!-- -->
 <!-- Use -->
 <!-- -->  
 
 <xsl:template match="//tdg:CorpusMetadata//tdg:ReferencedAssets">
  <xsl:for-each select="tdg:Asset/tdg:prop">
   <xsl:if test="@tdg:type='mime_type'">

    <xsl:if test='contains(@tdg:value, "application/")'>
     <field name="attachement">Application</field>
    </xsl:if>
    <xsl:if test='contains(@tdg:value, "audio/")'>
     <field name="attachement">Audio</field>
    </xsl:if>
    <xsl:if test='contains(@tdg:value, "image/")'>
     <field name="attachement">Image</field>
    </xsl:if>
    <xsl:if test='contains(@tdg:value, "message/")'>
     <field name="attachement">Message</field>
    </xsl:if>
    <xsl:if test='contains(@tdg:value, "model/")'>
     <field name="attachement">Model</field>
    </xsl:if>
    <xsl:if test='contains(@tdg:value, "multipart/")'>
     <field name="attachement">Multipart</field>
    </xsl:if>
    <xsl:if test='contains(@tdg:value, "text/")'>
     <field name="attachement">Document</field>
    </xsl:if>
    <xsl:if test='contains(@tdg:value, "video/")'>
     <field name="attachement">Video</field>
    </xsl:if>
   </xsl:if>
  </xsl:for-each>
 </xsl:template>

 <!-- Make sure that no fields get selected except those above -->
 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Content//tdg:Citation">
 </xsl:template>
 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Content//tdg:Version">
 </xsl:template>
 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Content//tdg:Version_Date">
 </xsl:template>
 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Content//tdg:Description">
 </xsl:template>
 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Responsibility">
 </xsl:template>
 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Linguistic//tdg:Annotation">
 </xsl:template>
 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Format//tdg:Encoding">
 </xsl:template>
 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Format//tdg:Extent">
 </xsl:template>
 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Format//tdg:Medium">
 </xsl:template>
 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Administrative">
 </xsl:template>
 <xsl:template match="//tdg:CorpusMetadata//tdg:CorpusContent//tdg:Use">
 </xsl:template>
 <xsl:template match="//tdg:CorpusBody//tdg:CorpusAnnotatedText//tdg:AnnotatedText">
 </xsl:template>
</xsl:stylesheet>