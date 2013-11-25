package com.thetdgroup.utils;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * A simple data structure that behaves like a StringBuilder, except you can add
 * inserts into it at specific character positions (0-based) containing strings
 * to be inserted at these positions. The toString() method will merge the
 * inserts and the string and return the full buffer.
 */
public class InsertableStringBuilder
{
 private StringBuilder stringBuilder;
 private SortedMap<Integer, String> inserts;

 /**
  * Default ctor.
  */
 public InsertableStringBuilder() 
 {
  this.stringBuilder = new StringBuilder();
  this.inserts = new TreeMap<Integer, String>();
 }

 /**
  * Ctor to instantiate this object with an input String.
  * 
  * @param s
  *         the input String to append.
  */
 public InsertableStringBuilder(String inputString) 
 {
  this();
  this.stringBuilder.append(inputString);
 }

 /**
  * Similar to StringBuilder.append(String). Allows appending strings to the
  * main input String.
  * 
  * @param s
  *         the String to append.
  */
 public void append(String inputString)
 {
  this.stringBuilder.append(inputString);
 }

 /**
  * Add an insert string at the specified position. If an attempt is made to
  * insert past the end of the current input String an
  * ArrayIndexOutOfBoundsException will be thrown. If an insert already exists
  * at the requested position, the replace parameter controls whether the new
  * insert overwrites the older one or is ignored.
  * 
  * @param position
  *         the position to insert into.
  * @param s
  *         the insert string.
  * @param replace
  *         if true, older insert at this position, if present, will be replaced
  *         by this newer one.
  */
 public void insert(int position, String inputString, boolean replace)
 {
  if(position > stringBuilder.length())
  {
   throw new IndexOutOfBoundsException("Can't insert past end of string (pos=" + position + ", len=" + stringBuilder.length() + ")");
  }
  
  if(!replace)
  {
   if(!this.inserts.containsKey(position))
   {
    this.inserts.put(position, inputString);
   }
  }
  else
  {
   this.inserts.put(position, inputString);
  }
 }

 /**
  * Merges the input String and all the insert Strings to create the merged
  * string.
  * 
  * @return the merged string.
  */
 @Override
 public String toString()
 {
  StringBuilder outStringBuffer = new StringBuilder();
  int iPosition = 0;
  
  for(int iPos : inserts.keySet())
  {
   if(iPosition < iPos)
   {
    outStringBuffer.append(stringBuilder.subSequence(iPosition, iPos));
   }
   
   outStringBuffer.append(inserts.get(iPos));
   iPosition = iPos;
  }
  
  if(iPosition < stringBuilder.length())
  {
   outStringBuffer.append(stringBuilder.subSequence(iPosition, stringBuilder.length()));
  }
  
  //
  return outStringBuffer.toString();
 }
}
