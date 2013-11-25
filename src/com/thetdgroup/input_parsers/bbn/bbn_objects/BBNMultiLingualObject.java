package com.thetdgroup.input_parsers.bbn.bbn_objects;

public class BBNMultiLingualObject
{
 private BBNSpeechFragmentObject sourceFragmentObject = null;
 private BBNSpeechFragmentObject mtFragmentObject = null;
 
 //
 public void addSourceSpeechFragment(BBNSpeechFragmentObject fragment)
 {
  this.sourceFragmentObject = fragment;
 }
 
 //
 public void addMTSpeechFragment(BBNSpeechFragmentObject fragment)
 {
  this.mtFragmentObject = fragment;
 }
 
 //
 public BBNSpeechFragmentObject getSourceObject()
 {
  return this.sourceFragmentObject;
 }
 
 public BBNSpeechFragmentObject getMTObject()
 {
  return this.mtFragmentObject;
 }
}
