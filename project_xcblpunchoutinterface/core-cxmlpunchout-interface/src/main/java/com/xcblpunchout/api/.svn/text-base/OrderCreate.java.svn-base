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
package com.cxmlpunchout.api;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.cxmlpunchout.db.OrderCreatePeer;
import com.cxmlpunchout.sebo.cxml.Status;
import com.cxmlpunchout.util.CustProperty;
import com.smartequip.common.ERPAPIConstant;
import com.smartequip.helper.RequestHelper;
import com.smartequip.util.DateUtils;
import com.smartequip.util.NumberUtils;


/**
 * @author Allwins Rajaiah
 * @date   22 Oct 2010
 *
 * Class reads SmartEquip request xml and creates a seRequest object to generate cxml request and reads cxml response to give proper notification to the client
 */
public class OrderCreate extends RequestHelper implements ERPAPIConstant{

	private static final Logger LOGGER = Logger.getLogger(OrderCreate.class);

	private static String vendorId;

	/**
	 *
	 */
	public OrderCreate() {
	}
	/**
	 *
	 * @param args
	 */
	public static void main(final String[] args) {
		new OrderCreate().doIt();
	}

	/*
	 * (non-Javadoc)
	 * @see com.smartequip.helper.RequestHelper#doIt()
	 */
	@Override
	public void doIt() {
		try {
			final OrderCreatePeer ocp = new OrderCreatePeer();

			final Map<String, Object> requestMap = readSeRequest();

			final Status cxmlResponseStatus = ocp.createOrder( requestMap, CustProperty.getProperty( vendorId, "CMLPUNCHOUTORDERURL" ) );

			if( cxmlResponseStatus != null ){
				if( NumberUtils.stringToInt( cxmlResponseStatus.getCode() ) == HttpServletResponse.SC_OK ){
					LOGGER.info("PUNCHOUT ORDER SUCCESSFUL ["+ cxmlResponseStatus.getCode() +"]["+ cxmlResponseStatus.getText() +"]");
					this.sendSuccessResponse( ObjectUtils.toString(requestMap.get( "cxml.seorderid")) );
				}else {
					LOGGER.error("PUNCHOUT ORDER UN-SUCCESSFUL ["+ cxmlResponseStatus.getCode() +"]["+ cxmlResponseStatus.getText() +"]");
					this.sendFailureResponse( cxmlResponseStatus.getText() );
				}
			}else{
				LOGGER.error("PUNCHOUT ORDER UN-SUCCESSFUL [Error Reading Response]");
			}
		} catch (final Exception e) {
			e.printStackTrace();
			sendFailureResponse(e.getMessage());
		}
	}

	/**
	 * Method reads RequestData xmlString and creates a map object with keys as <i>cxml.</i><B>the_se_request_element_node</B>
	 * the partsRec goes into a collection of <i>partrec</i>
	 * @return HashMap
	 */
	public HashMap<String, Object> readSeRequest() throws Exception{
		final HashMap<String, Object> _map = new HashMap<String, Object>();
		try {
			try {
				LOGGER.debug( "SE-ORDER REQUEST [XML]:\n" +  requestData.getXmlString() );

				final HashMap<String, HashMap<String,Object>> _partRecMap = new HashMap<String, HashMap<String,Object>>();
				final HashMap<String, Object> _partsMap = new HashMap<String, Object>();
				final HashMap<String, String> _extrinsicMap = null;

				final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				final DocumentBuilder db = dbf.newDocumentBuilder();
				final InputStream is = new ByteArrayInputStream( requestData.getXmlString().getBytes());
				final Document doc = db.parse( is );
				final Element docEle = doc.getDocumentElement();

				getSeOrderAttributes( docEle.getChildNodes(), _map, _partRecMap, _partsMap, _extrinsicMap );

				this.setVendorId( ObjectUtils.toString( _map.get("cxml.vendorid")) );
				LOGGER.info("VENDOR ID ["+ vendorId + "] SET FROM MAP");

				refreshSeOrderMapByProperties ( _map );
				getRequestPath( _map );
				refreshSeOrderMapAttributes( _map ); //refresh and set drop ship address as ship address
				refreshCountry( _map ); // set country code after refresh the map attributes. hence, drop ship address is taken care
				refreshReplyTo( _map );
				LOGGER.debug("SE-ORDER REQUEST MAP OBJECT CREATED");

			} catch (final SAXException e) {
				e.printStackTrace();
			} catch (final IOException e) {
				e.printStackTrace();
			}
		} catch ( final ParserConfigurationException e ) {
			LOGGER.error("Exception while parsing the SE-OrderRequest xml" , e );
		}
		return _map;
	}

	/*
	 * round of the currency value by 2 decimal points
	 */
	private static Object roundOff(Object object) {
		 float p = (float)Math.pow(10,2);
	      Float floatCurr = new Float(object.toString());
	      float Rval = floatCurr*p;
	      float tmp = Math.round(Rval);
	      float currencyValFloat = tmp/p;
	      DecimalFormat deciFormat = new DecimalFormat("0.00");
		return deciFormat.format(currencyValFloat);
	}
	/**
	 * Method generates error response with failure reason
	 *
	 * @param failureReason
	 */
	private void sendFailureResponse( final String failureReason ) {
		sbXMLResponse.append("<order-create>");
		sbXMLResponse.append("<request-status>failed</request-status>");
		sbXMLResponse.append("<error code='1'/>");
		sbXMLResponse.append("<msg>"+failureReason+"</msg>");
		sbXMLResponse.append("</order-create>");

	}
	/**
	 * Method generates successful response with order number
	 *
	 * @param orderNum
	 */
	private void sendSuccessResponse( final String orderNum ) {
		sbXMLResponse.append("<order-create>");
		sbXMLResponse.append("<request-status>success</request-status>");
		sbXMLResponse.append("<ordernum>"+ orderNum +"</ordernum>");
		sbXMLResponse.append("</order-create>");
	}
	/**
	 * Method reads seOrderRequest xml nodes and generates a map with key value pairs
	 * The keys are appened with <i>cxml.</i>node_of_sOrderRequest xml
	 *
	 * @param nodes The node of seOrderRequest xml document
	 * @param _map It stores all the
	 * @param _partRecMap It stores all the parts into _partsMap collection object
	 * @param _partsMap It stores each attribute as a record in the map
	 * @param _extrinsicMap It stores each extrinsic as a record in the map
	 */
	public static void getSeOrderAttributes ( final NodeList nodes, final HashMap<String,Object> _map, final HashMap<String,HashMap<String,Object>> _partRecMap, final HashMap<String,Object> _partsMap, HashMap<String,String> _extrinsicMap ) throws Exception{
		Element element = null;
		for (int i = 0; i < nodes.getLength(); i++) {
			final Node nNode = nodes.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				element = (Element) nNode;
				if( element.hasChildNodes() && element.getFirstChild().getNodeType() == Node.ELEMENT_NODE ) {
					getSeOrderAttributes ( element.getChildNodes(), _map, _partRecMap, _partsMap, _extrinsicMap );
				}
			}

			if( nNode.getNodeName().equals("partrec") ){
				if( nNode.getNextSibling() == null ){
					_map.put( "partrec", _partRecMap );
					//LOGGER.debug( "partrec > " + _partRecMap );
				}
			}
			else if( nNode.getParentNode().getNodeName().equals("partrec")){
				if( nNode.getNodeName().equals("extrinsic")){//skip if node is extrinsic
					if( nNode.getNextSibling() != null ) {
						continue;
					}
				}else { //store each nodes of partrec

					LOGGER.debug( "partsMap > " + element.getNodeName() + " : " + getCharacterDataFromElement(element));
					try{
					if(element.getNodeName().equals("netprice")){
						LOGGER.debug("string extnet price..."+getCharacterDataFromElement(element).toString());
						LOGGER.debug("double extnet price..."+Double.parseDouble(getCharacterDataFromElement(element).toString()));
						LOGGER.debug("rounded extnet price..."+roundOff(Double.parseDouble(getCharacterDataFromElement(element).toString())));
						LOGGER.debug("double qty..."+Double.parseDouble(_partsMap.get("cxml.qty").toString()));
						LOGGER.debug("rounded net price...::"+roundOff(Double.parseDouble(getCharacterDataFromElement(element).toString())/Double.parseDouble(_partsMap.get("cxml.qty").toString())));
						_partsMap.put( "cxml." + element.getNodeName() , roundOff(Double.parseDouble(getCharacterDataFromElement(element).toString())/Double.parseDouble(_partsMap.get("cxml.qty").toString())));
					}else{
						_partsMap.put( "cxml." + element.getNodeName() , getCharacterDataFromElement(element) );
					}
					}catch(Exception ex){
						LOGGER.error("Error occurred here ::"+ex.getMessage());
						ex.printStackTrace();
						throw new Exception(ex);
					}
				}

				if( nNode.getNextSibling() == null ){ // when no siblings found for partRec assign parts into partRec
					_partRecMap.put( "partrec" + _partRecMap.size() , new HashMap<String,Object>(_partsMap) );
					//LOGGER.debug( "partRecMap > partrec" + ( _partRecMap.size()- 1 ) + " : " + _partRecMap.get( "partrec" + ( _partRecMap.size() - 1 )));

					_partsMap.clear();
				}
			}else if( nNode.getParentNode().getNodeName().equals("extrinsic")){ //when the parentNode is extrinsic, store values into ExtrinsicMap
				if( CollectionUtils.isEmpty( _extrinsicMap )){ //if extrinsic map is null then create it
					_extrinsicMap = new HashMap<String,String>();
				}
				_extrinsicMap.put( "cxml.extrinsic.name." + element.getNodeName() , getCharacterDataFromElement(element) );
				//LOGGER.debug( "extrinsicMap > " + element.getNodeName() + " : " + getCharacterDataFromElement(element));

				if( nNode.getNextSibling() == null ){ //when no sibling found for extrinsic, add into partsMap
					_partsMap.put("extrinsic", _extrinsicMap );
					//LOGGER.debug( "partsMap > extrinsicMap : " + _extrinsicMap );

					_extrinsicMap = null;
				}
			}else{
				_map.put( "cxml." + element.getNodeName() , getCharacterDataFromElement(element) );
				//LOGGER.debug("map > " + element.getNodeName() + " : " + getCharacterDataFromElement(element));
			}
		}
	}
	/**
	 * Get values from properties and set into map
	 * PayloadId is <i>datetime.process id.random number@hostname</i>
	 * DUNS # is read from properties
	 * @param map
	 */
	private static void refreshSeOrderMapByProperties( final HashMap<String,Object> map ){
		map.put( "cxml.timestamp", DateUtils.todayInYYYY_MM_DD_HH_MM_SS());
		map.put("cxml.orderDate", DateUtils.todayInYYYY_MM_DD());
		try {
			final String payLoadId = DateUtils.todayInMM_DD_YYYY() + "." + ObjectUtils.toString( map.get("cxml.po")) + "." + new SecureRandom().nextInt() + "@" + InetAddress.getLocalHost().getHostName();
			map.put( "cxml.payloadId", payLoadId );
			map.put( "cxml.duns", CustProperty.getProperty( vendorId, "DUNSNUMBER" ) );
			map.put( "cxml.lang", CustProperty.getProperty( vendorId, "cxml.lang" ) );
			map.put( "cxml.default.value", CustProperty.getProperty( vendorId, "cxml.default.value" ) );
			map.put("cxml.requiredFields", CustProperty.getProperty( vendorId, "CMLPUNCHOUTREQUIRED" ) );
			map.put("cxml.childNodes", CustProperty.getProperty( vendorId, "cxml.trim.attributes" ) );
			map.put("cxml.parentNodes", CustProperty.getProperty( vendorId, "cxml.trim.parent.attributes" ) );

		} catch (final UnknownHostException e) {
			LOGGER.error( e.getMessage(), e );
		}
	}
	/**
	 * Method to override country code to default or the property value
	 *
	 * @param map map object which stores key values to generate cxml
	 */
	private static void refreshCountry( final HashMap<String,Object> map ){
		String statesProp = CustProperty.getProperty( vendorId, "cxml.us.states" );
		if( StringUtils.isNotBlank( statesProp )){
			String country_us = CustProperty.getProperty( vendorId, "cxml.country.us" );
			String country_non_us = CustProperty.getProperty( vendorId, "cxml.country.non.us" );
			map.put("cxml.cntry", getCountryForState( statesProp, ObjectUtils.toString( map.get("cxml.state")), country_us, country_non_us));
			map.put("cxml.bcountry", getCountryForState( statesProp, ObjectUtils.toString( map.get("cxml.bstate")), country_us, country_non_us));
		}
	}
	/**
	 * Method to override country code to default or the property value
	 *
	 * @param map map object which stores key values to generate cxml
	 */
	private static void refreshReplyTo( final HashMap<String,Object> map ){
		String parentNodes[] = StringUtils.split((String)map.get("cxml.parentNodes"), ",");
		for( String params : parentNodes ){
			String nullifyParams[] = StringUtils.split( params, "#" );
			if( map.containsKey( "cxml." + nullifyParams[0] + "type" )){
				if( ! ObjectUtils.toString( map.get( "cxml." + nullifyParams[0] + "type" )).equalsIgnoreCase( nullifyParams[1] )){
					map.put( "cxml." + nullifyParams[0], "" );
				}
			}
		}
	}
	/**
	 * Method returns country which matches
	 * @param allState
	 * @param state
	 * @param country1
	 * @param country2
	 * @return
	 */
	private static String getCountryForState( String allState, String state, String country1, String country2 ){
		return StringUtils.contains( allState, ObjectUtils.toString( state )) ?	country1 : country2;
	}
	/**
	 * Get cxml template path and store into map
	 *
	 * @param map map object which stores key values to generate cxml
	 */
	public static void getRequestPath( final HashMap<String,Object> map ){
		final String path = getPathFromUrl() + CustProperty.getProperty( vendorId, "cxml.resource.path" ) + map.get("cxml.vendorid") + ".xml";
		map.put( "cxml.resource.path", path );
		LOGGER.debug("CXML TEMPLATE FILE PATH : " + path );
	}
	/**
	 * Method refreshes shipAddress fields by populating dropAdress to them, if DropShipAddress entered
	 * and roundOff price and total based on roundoff attributes in property file
	 * @param map map object which stores key values to generate cxml
	 */
	public static void refreshSeOrderMapAttributes( final HashMap<String,Object> map ){
		// refresh shipAddress fields by populating dropAdress to them, if DropShipAddress entered
		if( StringUtils.isNotBlank( ObjectUtils.toString(map.get("cxml.dsname")))){
			String shipAddress  = CustProperty.getProperty( vendorId, "cxml.shipAddress" );
			for( String key : shipAddress.split(",") ){
				map.put( "cxml." + key, map.get( "cxml.ds" + key ));
			}
			//separate check for country
			map.put( "cxml.cntry", map.get( "cxml.dscountry" ));
		}
		// round of the currency value based on the roundoff property OEM - 535
		if(BooleanUtils.toBoolean(CustProperty.getProperty("cxml.roundoff"))){
			String cxmlPriceAttributes=CustProperty.getProperty(vendorId,"cxml.roundoff.attributes");
			for( String key : cxmlPriceAttributes.split(",") ){
				if(map.containsKey("cxml." + key )){
					map.put( "cxml." + key, roundOff(map.get( "cxml." + key )));
				}else{
					@SuppressWarnings("unchecked")
					final HashMap<String,HashMap<String,Object>> partRecMap = (HashMap<String,HashMap<String,Object>>)map.get( "partrec" );
					HashMap<String,Object> partMap = null;
					for( Entry<String, HashMap<String,Object>> entry : partRecMap.entrySet() ){
						partMap = entry.getValue();
						if( partMap.containsKey("cxml." + key ) ){
							partMap.put( "cxml." + key, roundOff(partMap.get( "cxml." + key )));
						}
					}
				}
			}
		}
	}

	/**
	 * Read current fileName path and convert path based on the system environment
	 * @return String path
	 */
	private static String getPathFromUrl(){
		String path = null;
		final URL classPath = OrderCreate.class.getResource( "OrderCreate.class" );
		path = classPath.toString();
		path = StringUtils.removeStart( StringUtils.remove( path, "file:/" ), "jar:" );
		path = StringUtils.substringBefore( path, StringUtils.contains( path, "lib") ? "lib" :"classes" );
		path = StringUtils.contains( path , ':') ? path : "/" + path;
		LOGGER.debug("CXML CLASS PATH FINAL: " + path );
		return path;
	}
	/**
	 * Get data from each node
	 *
	 * @param e Element
	 * @return
	 */
	private static String getCharacterDataFromElement(final Element e) {
		final Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			final CharacterData cd = (CharacterData) child;
			return (child.getNodeType() == Node.CDATA_SECTION_NODE ? "<![CDATA[" + cd.getData() + "]]>" : cd.getData());
		}
		return "";
	}
	/**
	 *
	 * @param vendorId
	 */
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
}
