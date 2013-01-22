/*
 *	$Source$
 *	$Name$
 *	$Revision: 42090 $
 *	$Date: 2010-09-14 17:27:09 -0400 (Tue, 14 Sep 2010) $
 *
 *	Copyright (c) 2001 - 2005, SmartEquip, Inc.
 *	83 East Avenue, Suite 101, Norwalk, CT 06851
 *
 *	Proprietary
 *	All Rights Reserved
 */

package com.cxmlpunchout.util;

import java.io.File;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.smartequip.common.Property;

public class CustProperty
{
    // Logger
	private static final Logger LOGGER = Logger.getLogger(CustProperty.class);

    private static Properties p = null;
    private static String pFileName = "cxmlpunchout.properties";
    private CustProperty()
    {
    }

    /**
     *
     * @param key
     * @return
     */
    public static String getProperty(String key)
    {
       // if (p == null)
        //{
            p = Property.readProperty( File.separator + pFileName );
        //}
        String s = p.getProperty(key);
        return (s == null) ? "" : s;
    }
    /**
     * Read Properties based on Vendor Id
     *
     * @param vendorId Vendor Id
     * @param key Key
     * @return Property value
     */
    public static String getProperty(String vendorId, String key)
    {
    	LOGGER.info("The vendor id is ::"+vendorId);

    	LOGGER.info("The file path is ::"+"/manufacturers/resource/" + vendorId + "." + pFileName);

    //	if (p == null)
      //  {
            p = Property.readProperty( "/manufacturers/resource/" + vendorId + "." + pFileName );
        //}

        String s = p.getProperty(key);
        return (s == null) ? "" : s;
    }
}
