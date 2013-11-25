package com.thetdgroup.input_parsers.netgister.named_entities_objects;

public class DetectedInstance
{
	private String instanceID = "";
	private String instanceType = "";
	private String instanceDetection = "";
	private String instanceName = "";
 private String instanceOffset = "";
 private String instanceLength = "";
 private String instanceSuffix = "";
 private String instancePrefix = "";
 
 //
 public String getInstanceID()
	{
	 return instanceID;
	}

	public void setInstanceID(String instanceID)
	{
	 this.instanceID = instanceID;
	}

	public String getInstanceDetection()
 {
  return instanceDetection;
 }

	public void setInstanceDetection(String instanceDetection)
 {
  this.instanceDetection = instanceDetection;
 }
 
 public String getInstanceType()
 {
  return instanceType;
 }

 public void setInstanceType(String instanceType)
 {
  this.instanceType = instanceType;
 }
 
 public String getInstanceName()
	{
 	return instanceName;
	}

 public String getInstanceSuffix()
 {
  return instanceSuffix;
 }

 public void setInstanceSuffix(String instanceSuffix)
 {
  this.instanceSuffix = instanceSuffix;
 }

 public String getInstancePrefix()
 {
  return instancePrefix;
 }

 public void setInstancePrefix(String instancePrefix)
 {
  this.instancePrefix = instancePrefix;
 }

 public void setInstanceName(String instanceName)
	{
 	this.instanceName = instanceName;
	}

 public Integer getInstanceOffset()
 {
  return Integer.parseInt(instanceOffset);
 }
	
	public void setInstanceOffset(String instanceOffset)
	{
 	this.instanceOffset = instanceOffset;
	}
	
	public int getInstanceLength()
	{
	 return Integer.parseInt(instanceLength);
	}
	
	public void setInstanceLength(String instanceLength)
	{
	 this.instanceLength = instanceLength;
	}

 public String getSuffix()
 {
  return instanceSuffix;
 }

 public void setSuffix(String suffix)
 {
  this.instanceSuffix = suffix;
 }

 public String getPrefix()
 {
  return instancePrefix;
 }

 public void setPrefix(String prefix)
 {
  this.instancePrefix = prefix;
 }
 
 //
 public void print()
 {
 System.out.println("Instance ID: " +  instanceID);
	 System.out.println("Instance Type: " +  instanceType);
	 System.out.println("Instance Detection: " + instanceDetection);
	
	 System.out.println("Instance Prefix: " +  instancePrefix);
  System.out.println("Instance Name: " + instanceName);
  System.out.println("Instance Suffix: " +  instanceSuffix);
  System.out.println("Instance Offset: " + instanceOffset);
  System.out.println("Instance Length: " + instanceLength);
  
  System.out.println("\n");
 }
}
