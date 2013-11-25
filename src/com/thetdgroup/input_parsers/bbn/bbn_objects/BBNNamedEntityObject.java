package com.thetdgroup.input_parsers.bbn.bbn_objects;

public class BBNNamedEntityObject
{
 private String tokenID = "";
	private String fragmentID = "";
 private String namedEntityID = "";
 private String namedEntityType = "";
 private String nameEntityValue = "";
 private String namedEntityBoundary = "";
 private String tokenLanguage = "";
 
 //
	public String getTokenID()
	{
	 return tokenID;
	}
	
	public void setTokenID(String tokenID)
	{
	 this.tokenID = tokenID;
	}
	
 public String getFragmentID()
	{
	 return fragmentID;
	}

	public void setFragmentID(String fragmentID)
	{
	 this.fragmentID = fragmentID;
	}
	
	public String getNamedEntityID()
	{
	 return namedEntityID;
	}
	
	public void setNamedEntityID(String namedEntityID)
	{
	 this.namedEntityID = namedEntityID;
	}
	
	public String getNamedEntityType()
	{
	 return namedEntityType;
	}
	
	public void setNamedEntityType(String namedEntityType)
	{
	 this.namedEntityType = namedEntityType;
	}
	
	public String getNameEntityValue()
	{
	 return nameEntityValue;
	}
	
	public void setNameEntityValue(String nameEntityValue)
	{
	 this.nameEntityValue = nameEntityValue;
	}

	public String getNamedEntityBoundary()
	{
	 return namedEntityBoundary;
	}

	public void setNamedEntityBoundary(String namedEntityBoundary)
	{
	 this.namedEntityBoundary = namedEntityBoundary;
	}

	public String getTokenLanguage()
	{
	return tokenLanguage;
	}

	public void setTokenLanguage(String tokenLanguage)
	{
	this.tokenLanguage = tokenLanguage;
	}

}
