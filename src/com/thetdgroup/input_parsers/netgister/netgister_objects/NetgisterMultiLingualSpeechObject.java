package com.thetdgroup.input_parsers.netgister.netgister_objects;

public class NetgisterMultiLingualSpeechObject
{
 private NetgisterSpeechObject sourceSpeechObject = null;
 private NetgisterSpeechObject targetSpeechObject = null;
 
 //
 public void addSourceFragment(NetgisterSpeechObject fragment)
 {
  this.sourceSpeechObject = fragment;
 }
 
 //
 public void addTargetFragment(NetgisterSpeechObject fragment)
 {
  this.targetSpeechObject = fragment;
 }
 
 //
 public NetgisterSpeechObject getSourceSpeechObject()
 {
  return this.sourceSpeechObject;
 }
 
 public NetgisterSpeechObject getTargetSpeechObject()
 {
  return this.targetSpeechObject;
 }
}
