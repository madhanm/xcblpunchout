/*
 *	$Source$
 *	$Name$
 *	$Revision: 12843 $
 *	$Date: 2008-03-21 12:28:52 -0500 (Fri, 21 Mar 2008) $
 *
 *	Copyright (c) 2001 - 2005, SmartEquip, Inc.
 *	83 East Avenue, Suite 101, Norwalk, CT 06851
 *
 *	Proprietary
 *	All Rights Reserved
 */

package com.xcblpunchout.api;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.apache.log4j.Logger;

import com.xcblpunchout.db.CheckAvailabilityPeer;
import com.xcblpunchout.sebo.PartError;
import com.xcblpunchout.sebo.PartRequest;
import com.xcblpunchout.sebo.PartsAvailability;
import com.smartequip.helper.RequestHelper;
import com.smartequip.util.StringUtils;


public class CheckAvailability extends RequestHelper
{
    // Logger
	private static final Logger LOGGER = Logger.getLogger(CheckAvailability.class);
	
	static final private String PART_NOT_FOUND = "PART NOT FOUND";

    public void doIt(){/*
    		//ArrayList parts = new ArrayList();
    		LinkedHashSet partsList = new LinkedHashSet();
    		ArrayList reqPartsList = new ArrayList();
    		// Process the XML parameters
	        Document doc = requestData.getContent();
	        NodeList req = doc.getElementsByTagName("request");
	        Element elem = (Element) req.item(0);

	        String sReqType = StringUtils.extractXMLvalue( (Element) req.item(0),"reqtype");
	        LOGGER.info("Request Type is: " + sReqType);


	        NodeList nlHeader = elem.getElementsByTagName("hdrrec");
	        String sSalesDoc_type = StringUtils.extractXMLvalue( (Element) nlHeader.item(0), "doctype");
	        String sPlant = StringUtils.extractXMLvalue( (Element) nlHeader.item(0), "plant");
	        String sCustomer = StringUtils.extractXMLvalue( (Element) nlHeader.item(0), "custid");
	        String sOrderType = StringUtils.extractXMLvalue((Element) nlHeader.item(0), "ordtype");

	        sPlant = DeutzProperties.getProperty("plant");;

	        LOGGER.info("sDocType: " + sSalesDoc_type
	                     + "\n sOrderType: " + sOrderType
	                     + "\n sCustomer: " + sCustomer
	                     + "\n sPlant: " + sPlant
	                 );


	        NodeList nlPartRec = elem.getElementsByTagName("partrec");
	        int cnt = nlPartRec.getLength();
	        for (int k = 0; k < cnt; k++){
	    	    PartRequest part= new  PartRequest();
	    	   	Element nPartRec = (Element) nlPartRec.item(k);
	            String item = StringUtils.extractXMLvalue(nPartRec, "partnum").toUpperCase();
	            String num = StringUtils.extractXMLvalue(nPartRec, "qty");
	            LOGGER.info("Adding item::"+item+" qty::"+num);

	            part.setReqPartNumber(item);
	            part.setFormattedPartNumber(DeutzUtil.getFormattedNumber(item));
	            part.setReqPartQty(num);
	            reqPartsList.add(part);
	            partsList.add(DeutzUtil.getFormattedNumber(item));
	       }

	        LOGGER.info("partsList size ::"+partsList.size());
	        LOGGER.info("partsList ::"+partsList);

	        CheckAvailabilityPeer checkAvailPeer = new CheckAvailabilityPeer();
	        HashMap retrDataMap = checkAvailPeer.checkAvailability(partsList,sOrderType,sPlant,sCustomer);
	        LOGGER.info("The number of parts from erp system is ::"+retrDataMap.size());

		    	if (retrDataMap.size() > 0){
		            formatReturnXML(retrDataMap,reqPartsList);
		            LOGGER.info("response xml==="+sbXMLResponse);
		        }else{
		            negativeAck("Items not found in ERP system");
		        }*/
		}


//    /*************************************************************************
//     * formatReturnXML
//     * @param retrDataMap -
//     * @param checkAvailPeer -
//     **************************************************************************/
    public void formatReturnXML(HashMap retrDataMap,ArrayList ReqPartList)
    {
       /* LOGGER.debug("Formatting return XML");
        sbXMLResponse.append("<check-availability>");
        sbXMLResponse.append("<request-status>success</request-status>");
        Iterator ReqPartListItr = ReqPartList.iterator();

        while(ReqPartListItr.hasNext()){
        	PartRequest partReq = (PartRequest)ReqPartListItr.next();
        	String reqPartNumber = partReq.getReqPartNumber();
        	LOGGER.debug(">> reqPartNumber " + reqPartNumber );
        	String formattedPartNum = partReq.getFormattedPartNumber();
        	LOGGER.debug(">> formattedPartNum " + formattedPartNum );

        	String reqPartQty = partReq.getReqPartQty();

        	//LOGGER.info("reqPartNumber in while loop****"+reqPartNumber);
        	//LOGGER.info("formattedPartNum in while loop****"+formattedPartNum);
        	String listPrice = null;
        	String netprice = null;
        	float listPriceFloat = 0;
        	float netPriceFloat = 0;

        	if( retrDataMap.containsKey(formattedPartNum) ) {
        	
        		Object retrDataMapObj = retrDataMap.get(formattedPartNum);
        		
        		LOGGER.debug(">> retrDataMapObj instanceof PartsAvailability ? " + (  retrDataMapObj instanceof PartsAvailability ) );
        		LOGGER.debug(">> retrDataMapObj instanceof PartError ? " + (  retrDataMapObj instanceof PartError ) );
        		
        		if( retrDataMapObj instanceof PartsAvailability )
        		{
        			LOGGER.info("Parts Available for : " + reqPartNumber );
        			PartsAvailability pa = (PartsAvailability)retrDataMapObj;
        			//LOGGER.info("reqPartNumber in if block ****"+pa.getReqPartNum());
        			sbXMLResponse.append("<record>");
        			sbXMLResponse.append("<itemnum>" + pa.getItemNumber() +"</itemnum>");
        			sbXMLResponse.append("<partnum>" + reqPartNumber +"</partnum>");
        			String desc = StringUtils.escapeHTML(pa.getMaterialDesc().trim());
        			desc = StringUtils.removeMultipleSpace(desc);
        			sbXMLResponse.append("<partdesc>" + desc + "</partdesc>");
        			sbXMLResponse.append("<confqty>" + pa.getConfirmedQty() +"</confqty>");
        			sbXMLResponse.append("<reqty>" + reqPartQty +"</reqty>");

        			listPrice = StringUtils.replace(pa.getPrice(),",","");
        			netprice = StringUtils.replace(pa.getNetPrice(),",","");
        			if(listPrice != null && !listPrice.equalsIgnoreCase("0") && !listPrice.equalsIgnoreCase("") ){
        				listPriceFloat = Float.parseFloat(listPrice);
        			}
        			if(netprice != null && !netprice.equalsIgnoreCase("0") && !netprice.equalsIgnoreCase("") ){
        				netPriceFloat = Float.parseFloat(netprice)* (Float.parseFloat(reqPartQty));
        			}

        			sbXMLResponse.append("<listprice>" + listPriceFloat +"</listprice>");
        			sbXMLResponse.append("<netprice>" + netPriceFloat +"</netprice>");

        			if(listPriceFloat > 0 && netPriceFloat > 0){
        				sbXMLResponse.append("<pricingexist>" + "Y" +"</pricingexist>");
        			}else{
        				sbXMLResponse.append("<pricingexist>" + "N" +"</pricingexist>");
        			}


        			sbXMLResponse.append("<supnum>" + ((pa.getSupnum()!=null && !pa.getSupnum().equalsIgnoreCase(""))?DeutzUtil.getFormattedETLNumber(DeutzUtil.removeLeadingZeros(pa.getSupnum().trim())):"") +"</supnum>");
        			sbXMLResponse.append("<supdesc>" +StringUtils.escapeHTML(pa.getSupdesc().trim()) + "</supdesc>");

        			sbXMLResponse.append("<hascomments>false</hascomments>");
        			sbXMLResponse.append("<comments></comments>");
        			sbXMLResponse.append("<manufacturerComments></manufacturerComments>");

        			if(pa.getSuperList()!=null && pa.getSuperList().size()>0){
        				Iterator supetListItr = pa.getSuperList().iterator();
        				while(supetListItr.hasNext()){
        					PartsAvailability subPart = (PartsAvailability)supetListItr.next();
        					sbXMLResponse.append("<suppart ");
        					sbXMLResponse.append("mnum='" + ((subPart.getReqPartNum()!=null && !pa.getSupnum().equalsIgnoreCase(""))? DeutzUtil.getFormattedETLNumber(DeutzUtil.removeLeadingZeros(subPart.getReqPartNum().trim())):"") + "' ");
        					sbXMLResponse.append("desc='" + StringUtils.escapeHTML(subPart.getMaterialDesc()) + "' ");
        					sbXMLResponse.append("confqty='" + subPart.getConfirmedQty() + "' ");

        					String subpartListPrice = StringUtils.replace(subPart.getPrice(),",","");
        					String subpartNetPrice = StringUtils.replace(subPart.getNetPrice(),",","");
        					float subpartListPriceFloat = 0;
        					float subpartNetPriceFloat = 0;

        					if(subpartListPrice != null &&  !subpartListPrice.equalsIgnoreCase("0") && !subpartListPrice.equalsIgnoreCase("")){
        						subpartListPriceFloat =  Float.parseFloat(subpartListPrice);
        					}else{
        						subpartListPriceFloat =  listPriceFloat ;
        					}

        					if(subpartNetPrice != null && !subpartNetPrice.equalsIgnoreCase("0") && !subpartNetPrice.equalsIgnoreCase("")){
        						subpartNetPriceFloat =  (Float.parseFloat(subpartNetPrice) * (Float.parseFloat(reqPartQty)));
        					}else{
        						subpartNetPriceFloat = netPriceFloat ;
        					}

        					sbXMLResponse.append("listprice='" + subpartListPriceFloat + "' ");
        					sbXMLResponse.append("netprice='" + subpartNetPriceFloat+ "' ");
        					if(subpartListPriceFloat >0 && subpartNetPriceFloat >0){
        						sbXMLResponse.append("pricingexists='" + "Y" + "' ");
        					}else{
        						sbXMLResponse.append("pricingexists='" + "N" + "' ");
        					}

        					sbXMLResponse.append("sup='" + "Y" + "' ");
        					sbXMLResponse.append("/>");
        				}
        			}
        			sbXMLResponse.append("</record>");

        		}else if( retrDataMapObj instanceof PartError ){
        			PartError partError = (PartError) retrDataMapObj;
        			
        			if( partError.getErrorMsg().equalsIgnoreCase(PART_NOT_FOUND)) {
        				generatePartNotFoundResponse( reqPartNumber );
        			}else {
        				generatePartNotOrderableResponse(partError, reqPartNumber);
        			}
        		}
        	}
        	else{
        		generatePartNotFoundResponse( reqPartNumber );
        	}
        }
         sbXMLResponse.append("</check-availability>");*/
    }

    /**
     * Method returns PartNotFound Response
     * 
     * @param reqPartNumber
     */
    public void generatePartNotFoundResponse( String reqPartNumber ) {
    	sbXMLResponse.append("<record>");
		sbXMLResponse.append("<partnum>" + reqPartNumber+ "</partnum>");
		sbXMLResponse.append("<itemexists>N</itemexists>");
		sbXMLResponse.append("<hascomments>false</hascomments>");
		sbXMLResponse.append("<vldtmsg>PART NOT FOUND</vldtmsg>");
		sbXMLResponse.append("<confqty>0</confqty>");
		sbXMLResponse.append("</record>");
		
		LOGGER.info("Part Un-available for : " + reqPartNumber );
    }
    /**
     * Method returns PartNotOrderable Response
     * 
     * @param partError
     * @param reqPartNumber
     */
    public void generatePartNotOrderableResponse( PartError partError, String reqPartNumber ) {
    	sbXMLResponse.append("<record>");
		sbXMLResponse.append("<partnum>" + reqPartNumber+ "</partnum>");
		sbXMLResponse.append("<itemexists>Y</itemexists>");
		sbXMLResponse.append("<orderable>N</orderable>");
		sbXMLResponse.append("<vldtmsg>PART NOT ORDERABLE</vldtmsg>");
		sbXMLResponse.append("<confqty>0</confqty>");
		sbXMLResponse.append("<hascomments>true</hascomments>");
		sbXMLResponse.append("<manufacturerComments>"+ partError.getErrorMsg() +"</manufacturerComments>");
		sbXMLResponse.append("</record>");
		LOGGER.info("Part Un-available for : " + reqPartNumber + " ie, " + partError.getErrorMsg() );
    }
}
