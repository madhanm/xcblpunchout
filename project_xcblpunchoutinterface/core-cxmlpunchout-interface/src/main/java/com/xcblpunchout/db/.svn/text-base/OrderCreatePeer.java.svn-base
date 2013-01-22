/*
 *	$Source$
 *	$Name$
 *	$Revision: 1 $
 *	$Date: 2010-10-22 15:00:24 +0530 (Fri, 22 Oct 2010) $
 *
 *	Copyright (c) 2002 - 2005, SmartEquip, Inc.
 *	83 East Avenue, Suite 101, Norwalk, CT 06851
 *
 *	Proprietary
 *	All Rights Reserved
 */
package com.cxmlpunchout.db;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.log4j.Logger;

import com.cxmlpunchout.sebo.cxml.CXML;
import com.cxmlpunchout.sebo.cxml.Status;
import com.smartequip.util.StringUtils;

/**
 * @author Allwins Rajaiah
 * @date 22 Oct 2010
 *
 *       Class has methods to create punchout order in cxml format. It sends and
 *       receives the same
 */
public class OrderCreatePeer {

	private static final Logger LOGGER = Logger
			.getLogger(OrderCreatePeer.class);

	/**
	 * Creates, Send and Receive CXML Punchout Order request
	 *
	 * @param requestObj
	 *            Request objected created by parsing the SE Order Request xml
	 * @param endPoint
	 *            End Point Address
	 * @return status CXML.Response.Status
	 * @throws Exception
	 */
	public Status createOrder(final Map<String, Object> requestMap,
			final String endPoint) {
		LOGGER.info("The end point is ::"+endPoint);
		try {
			// read CXML template
			final StringBuffer xmlTemplateBuf = getManufacurerXMLTemplate(requestMap);

			// generate CXML
			final String orderReqCXML = updateXMLTemplate(requestMap,xmlTemplateBuf.toString());

			// send and Receive
			final String response = sendOrderRequest(orderReqCXML, endPoint);

			// read response
			return receiveOrderResponse(response);

		} catch (final Exception e) {
			LOGGER.error("Order not processed by Manufacturer.", e);
		}
		return null;
	}

	/**
	 * Read manufacturer based cxml template
	 *
	 * @param manufacurerId
	 *            Manufacturer/vendorId
	 * @return cxml template
	 */
	static public StringBuffer getManufacurerXMLTemplate(final Map<String, Object> requestMap) {
		final StringBuffer contents = new StringBuffer();
		int nodeLoop=0;
		boolean lineAppend=false;
		try {
			final String fileName = ObjectUtils.toString(requestMap.get("cxml.resource.path"));
			final File file = new File(fileName);
			if (file.exists()) {
				final boolean conditionsRequired= BooleanUtils.toBoolean((String)requestMap.get("cxml.requiredFields"));
				if(conditionsRequired==true){
					List<String> fileList = FileUtils.readLines(file);
					//Gather child node information
					String childNodes[]=StringUtils.split((String)requestMap.get("cxml.childNodes"), ",");
					String partentNodes[]=StringUtils.split((String)requestMap.get("cxml.parentNodes"), ",");
					for (Iterator<String> it = fileList.iterator(); it.hasNext();) {
						lineAppend=false;
						String line = it.next();
						String childNodeValue="";
						//child node remove from CXML file if null or blank based on input from properties file
						for(nodeLoop=0;nodeLoop<childNodes.length;nodeLoop++){
							childNodeValue=(String) requestMap.get("cxml."+childNodes[nodeLoop]);
							if (line.contains("cxml."+childNodes[nodeLoop]) && StringUtils.nullOrBlank(childNodeValue)) {
								contents.append("");
								lineAppend=true;
							}
						}
						for(nodeLoop=0;nodeLoop<partentNodes.length;nodeLoop++){
							String nodes[]=StringUtils.split(partentNodes[nodeLoop],"#");
							if(line.contains("<"+nodes[1])){
								String parentNodeValue=new String();
								while(!line.contains("</"+nodes[1]+">")){
									parentNodeValue=parentNodeValue+line;
									line=it.next();
								}
								parentNodeValue=parentNodeValue+line;
								childNodeValue=(String) requestMap.get("cxml."+nodes[0]);
								if(parentNodeValue.contains("cxml."+nodes[0]) && StringUtils.nullOrBlank(childNodeValue)){
									contents.append("");
									lineAppend=true;
								}else{
									contents.append(parentNodeValue);
									lineAppend=true;
								}
							}
						}
						if(!lineAppend){
							contents.append(line);
						}
					}
				}else{
					contents.append(FileUtils.readFileToString(file));
				}
				LOGGER.debug("CXML TEMPLATE :" + contents.toString());
			} else {
				LOGGER.error("CXML TEMPLATE FILE READ UNSUCCESSFULL. FILE NOT FOUND");
			}
		} catch (final IOException ex) {
			LOGGER.error("CXML TEMPLATE FILE READ UNSUCCESSFULL", ex);
		}
		return contents;
	}

	/**
	 * Method updates cxml template by populating the values from requestMap
	 * which was created by reading seOrderRequest xml String
	 *
	 * @param map
	 *            Request map which has elements of seOrderRequest as a key
	 * @param str
	 * @return
	 */
	public static String updateXMLTemplate(final Map<String, Object> map,
			String str) {
		for (final Entry<String, Object> entry : map.entrySet()) {
			str = str.replaceAll(entry.getKey(), Matcher.quoteReplacement(StringUtils.encodeHTML(ObjectUtils.toString(entry.getValue()))));
		}
		// LOGGER.debug( "MANUFACTURER TEMPLATE [CXML][HEADER FILL]:\n" + newStr
		// );
		return updateItemoutInXMLTemplate(map, str);
	}

	/**
	 * Method updates ItemOut of the XML template It appends Extrinsic elements
	 * based on the Extrinsic map size
	 *
	 * @param map
	 *            Map contains the key value pairs to update the ItemOut Node in
	 *            the xml template
	 * @param str
	 *            The XML template which has to be updated
	 * @return The updated ItemOut element
	 */
	@SuppressWarnings("unchecked")
	public static String updateItemoutInXMLTemplate(
			final Map<String, Object> map, final String str) {
		String newStr = null;
		final StringBuffer newItemOutBuf = new StringBuffer();
		final StringBuffer newExtrinsicBuf = new StringBuffer();
		final String itemOut = str.substring(str.indexOf("<ItemOut"),str.lastIndexOf("</ItemOut>") + "</ItemOut>".length());
		final String extrinsic = org.apache.commons.lang.StringUtils.contains(itemOut, "<Extrinsic") ? itemOut.substring(itemOut.indexOf("<Extrinsic"),itemOut.lastIndexOf("</Extrinsic>") + "</Extrinsic>".length())	: "";
		final HashMap<String, HashMap<String, Object>> partRecMap = (HashMap<String, HashMap<String, Object>>) map.get("partrec");
		HashMap<String, Object> partsMap = null;
		HashMap<String, String> extrinsicMap = null;
		String newItem = null;
		String newExtrinsic = null;
		for (final Entry<String, HashMap<String, Object>> partRecMapEntry : partRecMap.entrySet()) {
			partsMap = partRecMapEntry.getValue();
			newItem = itemOut;
			for (final Entry<String, Object> partsEntry : partsMap.entrySet()) {
				if (StringUtils.equals("extrinsic", partsEntry.getKey())) {
					extrinsicMap = (HashMap<String, String>) partsEntry.getValue();
					for (final Entry<String, String> extrinsicEntry : extrinsicMap.entrySet()) {
						newExtrinsic = extrinsic;
						newExtrinsic = newExtrinsic.replace("cxml.extrinsic.name", Matcher.quoteReplacement(StringUtils.encodeHTML(org.apache.commons.lang.StringUtils.substringAfter(extrinsicEntry.getKey(),"cxml.extrinsic.name."))));
						newExtrinsic = newExtrinsic.replace("cxml.extrinsic.value", Matcher.quoteReplacement(StringUtils.encodeHTML(extrinsicEntry.getValue())));

						newExtrinsicBuf.append(newExtrinsic + "\n");
					}
				} else {
					newItem = newItem.replaceAll(partsEntry.getKey(),Matcher.quoteReplacement(StringUtils.encodeHTML(ObjectUtils.toString(partsEntry.getValue()))));
				}
			}
			if (org.apache.commons.lang.StringUtils.contains(newItem, "<Extrinsic")) { // if extrinsic available in newItem then
										// replace with newExtrinsic info
				newItem = StringUtils.replace(newItem, newItem.substring(newItem.indexOf("<Extrinsic"),newItem.lastIndexOf("</Extrinsic>")+ "</Extrinsic>".length()),org.apache.commons.lang.StringUtils.trim(newExtrinsicBuf.toString()));
				newExtrinsicBuf.delete(0, newExtrinsicBuf.length());
			}

			newItemOutBuf.append(newItem + "\n");
		}
		newStr = StringUtils.replace(str, str.substring(str.indexOf("<ItemOut"), str.lastIndexOf("</ItemOut>")+ "</ItemOut>".length()),org.apache.commons.lang.StringUtils.trim(newItemOutBuf.toString()));

		LOGGER.info("MANUFACTURER TEMPLATE [CXML][ITEMOUT FILL][FINAL CXML]:\n"+ newStr);

		return newStr;
	}

	/**
	 * Send Order Request to the Manufacturer Punchout Server
	 *
	 * @param cxmlMessage
	 *            CXML message in String
	 * @param endPoint
	 *            manufacturer Punchout service address
	 * @return Response
	 * @throws Exception
	 */
	public String sendOrderRequest(final String cxmlMessage,
			final String endPoint) throws Exception {
		HttpURLConnection httpConnection = null;
		OutputStream senderStream = null;
		BufferedReader inputReader = null;
		String outputVal = "";
		try {
			final URL endpoint = new URL(endPoint);
			httpConnection = (HttpURLConnection) endpoint.openConnection();
			httpConnection.setDoInput(true);
			httpConnection.setDoOutput(true);
			httpConnection.setUseCaches(false);
			httpConnection.setRequestMethod("POST");
			httpConnection.setRequestProperty("Content-Length",String.valueOf(cxmlMessage.getBytes().length));
			httpConnection.setRequestProperty("Content-type", "text/xml");
			httpConnection.setRequestProperty("charset", "UTF-8");
			httpConnection.setRequestProperty("Connection", "Keep-Alive");
			httpConnection.setAllowUserInteraction(true);
			senderStream = httpConnection.getOutputStream();
			senderStream.write(cxmlMessage.getBytes());
			senderStream.flush();
			senderStream.close();
			LOGGER.debug("SENT SUCCESSFUL PUNCHOUT ORDER REQUEST with LENGTH :["+ cxmlMessage.getBytes().length+ " bytes]["+ cxmlMessage.length() + " chars]");

			httpConnection.connect();
			httpConnection.setReadTimeout(4000);
			inputReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
			String dataline = "";
			final StringBuffer outPut = new StringBuffer();
			while ((dataline = inputReader.readLine()) != null) {
				outPut.append(dataline);
			}
			if (outPut.toString() != null && outPut.toString().length() > 0) {
				outputVal = outPut.toString();
			}

		} catch (final ConnectException cex) {
			LOGGER.error(" Could not connect End point when trying to connect punchout server Connection Exception :",cex);
			throw cex;
		} catch (final SocketException skEx) {
			LOGGER.error(" Could not connect End point when trying to connect punchout server Socket Exception :",skEx);
			throw skEx;
		} catch (final IOException ioExep) {
			LOGGER.error(" Could not connect End point when trying to connect punchout server IOException :",ioExep);
			throw ioExep;
		} catch (final Exception ex) {
			LOGGER.error(" Could not connect End point when trying to connect punchout server  :",ex);
			throw ex;
		} finally {
			if (senderStream != null) {
				senderStream = null;
			}

			if (inputReader != null) {
				try {
					inputReader.close();
				} catch (final Exception ex) {
					LOGGER.error(" Exception when closing objects in finally :", ex);
				}
				inputReader = null;
			}
		}
		return outputVal;
	}

	/**
	 * Parses punchout response String
	 *
	 * @param response
	 *            Punchout Response xml
	 * @return status CXML.Response.Status
	 * @throws Exception
	 */
	public Status receiveOrderResponse(final String response) {
		try {
			LOGGER.debug("PUNCHOUT ORDER RESPONSE [CXML][" + response.length()+ "]:\n" + response);

			final JAXBContext context = JAXBContext.newInstance(new Class[] { CXML.class });
			final Unmarshaller unmarshaller = context.createUnmarshaller();
			final InputStream inputStream = new ByteArrayInputStream(response.getBytes());
			final CXML cxml = (CXML) unmarshaller.unmarshal(inputStream);
			return cxml.getResponse().getStatus();

		} catch (final Exception e) {
			LOGGER.error("Order not processed by Manufacturer.", e);
		}
		return null;

	}
}
