package com.thetdgroup.languages;

import comThetdgroupClLanguageIso639V1.LanguageCodeIso6392Type;
import comThetdgroupClLanguageIso639V1.LanguageCodeIso6392Type.Enum;

public final class LanguageConvert
{
	//
 public static String convertFromName(final String sourceLanguage)
 {
	 if(sourceLanguage.equalsIgnoreCase("arabic"))
	 {
	  return LanguageCodeIso6392Type.ARA.toString();
	 }
	 else if(sourceLanguage.equalsIgnoreCase("chinese"))
	 {
	 	return LanguageCodeIso6392Type.CHI.toString();
	 }  
	 else if(sourceLanguage.equalsIgnoreCase("spanish"))
	 {
	  return LanguageCodeIso6392Type.SPA.toString();
	 }
	 
	 return null;
 }
 
 //
 public static LanguageCodeIso6392Type.Enum convertFromISO2toISO3(final String language)
 {
		if(language.equalsIgnoreCase("KO"))
		{
			return LanguageCodeIso6392Type.KOR;
		}
		else if(language.equalsIgnoreCase("EN"))
		{
			return LanguageCodeIso6392Type.ENG;
		}
		else if(language.equalsIgnoreCase("AR"))
		{
			return LanguageCodeIso6392Type.ARA;
		}
		else if(language.equalsIgnoreCase("FR"))
		{
			return LanguageCodeIso6392Type.FRE;
		}
		else if(language.equalsIgnoreCase("ZH"))
		{
			return LanguageCodeIso6392Type.CHI;
		}		
		else if(language.equalsIgnoreCase("RU"))
		{
			return LanguageCodeIso6392Type.RUS;
		}
		else if(language.equalsIgnoreCase("ES"))
		{
			return LanguageCodeIso6392Type.SPA;
		}
		else
		{
			return Enum.forString(language);
		}
 }
}
