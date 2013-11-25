package com.thetdgroup.input_parsers.netgister.netgister_objects;

public class NetgisterMultiLingualObject
{
 private NetgisterTextObject sourceTextObject = null;
 private NetgisterTextObject mtTextObject = null;
 
 //
 public void addSourceTextFragment(NetgisterTextObject fragment)
 {
  this.sourceTextObject = fragment;
 }
 
 //
 public void addMTTextFragment(NetgisterTextObject fragment)
 {
  this.mtTextObject = fragment;
 }
 
 //
 public NetgisterTextObject getSourceObject()
 {
  return this.sourceTextObject;
 }
 
 public NetgisterTextObject getMTObject()
 {
  return this.mtTextObject;
 }
}
