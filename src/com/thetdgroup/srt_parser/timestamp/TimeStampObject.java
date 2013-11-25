package com.thetdgroup.srt_parser.timestamp;

import java.io.IOException;

import org.jdom.Element;
import org.jdom.JDOMException;

public final class TimeStampObject
{
 private String timeStart = "";
 private String timeEnd = "";
 private String tokenDuration = "";
 private String textContent = "";
 
 //
 public TimeStampObject(final String timeStart, final String tokenDuration, final String textContent)
 {
  this.timeStart = timeStart;
  this.timeEnd = String.valueOf(Float.parseFloat(timeStart) + Float.parseFloat(tokenDuration));
  this.tokenDuration = tokenDuration;
  this.textContent = textContent;
 }
 
 public String getTimeStart()
 {
  return timeStart;
 }

 public String getTimeEnd()
 {
  return this.timeEnd;
 }

 public String getTokenDuration()
 {
  return tokenDuration;
 }
 
 public String getTextContent()
 {
  return textContent;
 }

 //
 public Element toElement() throws JDOMException, IOException
 {
  Element element = new Element("timestamp_content", "tdg");
  element.setAttribute("start", this.timeStart);
  element.setAttribute("duration", this.tokenDuration);
  element.setAttribute("end", String.valueOf(Float.parseFloat(timeStart) + Float.parseFloat(tokenDuration)));
  element.setText(this.textContent);
  
  return element;
 }
}
