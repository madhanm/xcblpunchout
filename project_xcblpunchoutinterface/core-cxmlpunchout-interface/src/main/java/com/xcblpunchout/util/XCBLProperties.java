package com.xcblpunchout.util;


import java.util.*;
import com.smartequip.common.*;


public class XCBLProperties
{
  private static Properties p = null;
  private static String pFile = "/xcblpunchout.properties";
  private XCBLProperties()
  {
  }
  public static String getProperty(String key)
  {
      if (p == null)
      {
          p = Property.readProperty(pFile);
      }
      String s = p.getProperty(key);
      return (s == null)? "":s;
  }
}