package com.thetdgroup.input_parsers.netgister.netgister_objects;

public class NetgisterMultiLingualTextObject
{
 private String sourceText = "";
 private String targetText = "";
 
 //
 public void addSourceFragment(String textFragment)
 {
  sourceText = textFragment;
 }
 
 public void addTargetFragment(String textFragment)
 {
  targetText = textFragment;
 }
 
 //
 public String getSourceFragment()
 {
  return sourceText;
 }
 
 public String getTargetFragment()
 {
  return targetText;
 }
}
