/*
 *	$Source$
 *	$Name$
 *	$Revision: 7460 $
 *	$Date: 2007-05-12 17:34:49 -0400 (Sat, 12 May 2007) $
 *
 *	Copyright (c) 2006, SmartEquip, Inc.
 *	83 East Avenue, Suite 101, Norwalk, CT 06851
 *
 *	Proprietary
 *	All Rights Reserved
 */
package com.cxmlpunchout.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;

import com.smartequip.common.RequestData;
import com.smartequip.helper.RequestDirector;


@SuppressWarnings("serial")
public class RequestXCBLPunchout
extends RequestDirector {

	// Logger
	private static final Logger LOGGER =
		Logger.getLogger(RequestXCBLPunchout.class);


	/**
	 *  Returns whether the incoming request is a binary data request.
	 *
	 *  <p>
	 *  This request director does not process binary data request.  Hence,
	 *  this implementation will always return  <code>false</code>
	 *  </p>
	 *
	 * @param   request the HTTP request object associated with the
	 *                  incoming request.
	 * @return  <code>false</code>  always, since this request director does
	 *          not process binary data request.
	 */
	@Override
	protected boolean isBinaryDataRequest(HttpServletRequest request) {

		return  false;
	}


	/**
	 *  Extracts the command string for XML request.
	 *
	 * @param   request the HTTP request object associated with the
	 *                  incoming request.
	 * @return  the command string for XML request.
	 */
	@Override
	protected String getXMLCommandString(HttpServletRequest request) {

		return  request.getParameter("command");
	}


	/**
	 *  Checks whether a valid HTTP session exists.
	 *
	 *  <p>
	 *  This request director does not require caller to have valid HTTP
	 *  session.  Hence, this implementation will always return
	 *  <code>true</code>
	 *  </p>
	 *
	 * @param   request the HTTP request object associated with the
	 *                  incoming request.
	 * @param   response    the HTTP response object associated with the
	 *                      incoming request.
	 * @param   commandString   the command string for the incoming request.
	 * @return  <code>true</code>  always, since this request director does
	 *          not require caller to have valid HTTP session.
	 */
	@Override
	protected boolean hasHTTPSession(HttpServletRequest request,
			HttpServletResponse response, String commandString) {

		return  true;
	}


	/**
	 *  Creates and returns the proper request data object for XML request.
	 *
	 * @param   request the HTTP request object associated with the
	 *                  incoming request.
	 * @param   response    the HTTP response object associated with the
	 *                      incoming request.
	 * @param   commandString   the command string for the incoming request.
	 * @return  the request data object for XML request.
	 */
	@Override
	protected RequestData prepareXMLRequestData(
			HttpServletRequest request, HttpServletResponse response,
			String commandString) {

		RequestData requestData = new RequestData();
		requestData.setHttpServletRequest(request);
		requestData.setHttpServletResponse(response);
		requestData.setCommand(commandString);

		// Parse the XML input
		String inputXMLString = request.getParameter("content");
		try {

			requestData.setContentAsString(inputXMLString);

		} catch (DocumentException dex) {

			LOGGER.error("Failed to parse request XML.", dex);
			return  null;
		}

		logXMLRequest(inputXMLString, commandString,
		"No HTTP Session");

		return  requestData;
	}


	/**
	 *  Returns the helper package prefix for helper classes to be used by
	 *  this request director.
	 *
	 * @return  the helper package prefix for helper classes to be used by
	 *          this request director.
	 */
	@Override
	protected String getHelperPackagePrefix() {

		return  "com.cxmlpunchout.api.";
	}


	/**
	 *  Logs incoming XML for XML request.
	 *
	 * @param   xmlRequest  the XML request to be logged.
	 * @param   commandString   the command string for the incoming request.
	 * @param   sessionID   the session ID to be written into log.
	 */
	@Override
	protected void logXMLRequest(String xmlRequest, String commandString,
			String sessionID) {

		LOGGER.info("RequestXCBLPunchout in (" + commandString + ")=>" + sessionID +":"+
				xmlRequest);
	}


	/**
	 *  Logs response XML for XML request.
	 *
	 * @param   xmlResponse the XML response to be logged.
	 * @param   commandString   the command string for the incoming request.
	 * @param   sessionID   the session ID to be written into log.
	 */
	@Override
	protected void logXMLResponse(String xmlResponse, String commandString,
			String sessionID) {

		LOGGER.info("RequestXCBLPunchout out(" + commandString + ")=>" + sessionID
				+ ":" + xmlResponse);
	}
}
