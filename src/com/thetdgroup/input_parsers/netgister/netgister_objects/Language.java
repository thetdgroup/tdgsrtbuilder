package com.thetdgroup.input_parsers.netgister.netgister_objects;

public class Language
{
 private String languageName = "";
 private String languageISO2 = "";
 private String languageISO3 = "";
 private double languageProbability = 0.0;
 
 //
	public String getLanguageName()
	{
 	return languageName;
	}
	
	public void setLanguageName(String languageName)
	{
	 this.languageName = languageName;
	}
	
	public String getLanguageISO2()
	{
	 return languageISO2;
	}
	
	public void setLanguageISO2(String languageISO)
	{
 	this.languageISO2 = languageISO;
	}
	
	public String getLanguageISO3()
	{
	 return languageISO3;
	}
	
	public void setLanguageISO3(String languageISO)
	{
 	this.languageISO3 = languageISO;
	}
	
	public double getLanguageProbability()
	{
 	return languageProbability;
	}
	
	public String getLanguageProbabilityAsString()
	{
 	return Double.toString(languageProbability);
	}
	
	public void setLanguageProbability(double languageProbability)
	{
	 this.languageProbability = languageProbability;
	}
}
