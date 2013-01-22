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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.cxmlpunchout.api.OrderCreate;
import com.cxmlpunchout.sebo.cxml.Status;

/**
 * 
 * @author Allwins Rajaiah
 * @date 22 Oct 2010
 *
 */
@Ignore
public class OrderCreatePeerTest extends TestCase {

	private static final Logger LOGGER = Logger.getLogger(OrderCreate.class);

	@Autowired
	private OrderCreatePeer ocp;

	@Autowired
	private HashMap<String,Object> seRequestObj;

	@Autowired
	private Status status;

	private final String endPoint = "http://tradingpartner.qa.ehub.lifttrucksolutions.com/PurchaseOrderService.svc/submit";

	public HashMap<String,Object> createRequest( StringBuilder xml ) {
		HashMap<String, Object> requestMap = new HashMap<String, Object>(); 
		try {
			HashMap<String, HashMap<String,String>> _partRecMap = new HashMap<String, HashMap<String,String>>(); 
			HashMap<String, String> _partsMap = new HashMap<String, String>(); 

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputStream is = new ByteArrayInputStream( xml.toString().getBytes());
			Document doc = db.parse( is );
			Element docEle = doc.getDocumentElement();

			getChildNodeValues( docEle.getChildNodes(), requestMap, _partRecMap, _partsMap );
			getProperties( requestMap );
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch ( ParserConfigurationException e ) {
			LOGGER.error("Exception while parsing the SE-OrderRequest xml" , e );
		}
		return requestMap;
	}

	
	@Test
	public void testCreateOrder() throws Exception {
		try {

			LOGGER.debug( " seRequestObj : " + seRequestObj );

			status = ocp.createOrder( seRequestObj, endPoint );

			assertNotNull("Status received", status.getCode() );

			/*assertTrue( "order create success", Integer.parseInt(status.getCode()) == HttpServletResponse.SC_OK );
			assertTrue( "order create failed", Integer.parseInt(status.getCode()) != HttpServletResponse.SC_OK );*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		status = new Status();
		seRequestObj = createRequest( mockupInputXml() );
		ocp = new OrderCreatePeer();
	}

	@Override
	@After
	protected void tearDown() throws Exception {
		ocp = null;
	}


	public static void getChildNodeValues ( NodeList nodes, HashMap<String,Object> _map, HashMap<String,HashMap<String,String>> _partRecMap, HashMap<String,String> _partsMap ){
		Element element = null;
		for (int i = 0; i < nodes.getLength(); i++) {
			Node nNode = nodes.item(i);	  
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				element = (Element) nNode;
				if( element.hasChildNodes() && element.getFirstChild().getNodeType() == Node.ELEMENT_NODE ) {
					getChildNodeValues ( element.getChildNodes(), _map, _partRecMap, _partsMap );
				}
			}

			if( nNode.getNodeName().equals("partrec") ){
				if( nNode.getNextSibling() == null ){
					_map.put( "partrec", _partRecMap );
				}
			}
			else if( nNode.getParentNode().getNodeName().equals("partrec")){
				_partsMap.put( "cxml." + element.getNodeName() , getCharacterDataFromElement(element) );
				/*System.out.println( "partRecMap > " + element.getNodeName() + " : " + getCharacterDataFromElement(element));*/
				if( nNode.getNextSibling() == null ){
					_partRecMap.put( "partrec" + _partRecMap.size() , new HashMap<String,String>(_partsMap) );
					/*System.out.println( "partRecMap > " + _partRecMap );*/
					_partsMap = new HashMap<String, String>(); 
				}
			}else{
				_map.put( "cxml." + element.getNodeName() , getCharacterDataFromElement(element) );
				/*System.out.println( "map > " + element.getNodeName() + " : " + getCharacterDataFromElement(element));*/
			}
		}
	}
	/**
	 * 
	 * @param map
	 */
	public static void getProperties( HashMap<String,Object> map ){
		map.put( "cxml.timestamp", new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss" ).format( new Date()));
	}
	
	public static String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "";
	}
	
	protected StringBuilder mockupInputXml(){
		StringBuilder sb = new StringBuilder();
		sb.append(	"<?xml version='1.0'?>"+
				"<request>"+
				"<reqtype>OrderCreate</reqtype>"+
				//header
				"<hdrrec>"+
				"<doctype/>"+
				"<salesorg/>"+
				"<username>punchout</username>"+
				"<password>p@ssw0rd</password>"+
				"<custAcctNum>SE</custAcctNum>"+
				"<distchannel/>"+
				"<division/>"+
				"<prtnrole>AG</prtnrole>"+
				"<prtnnum>SE</prtnnum>"+
				"<shipto/>"+
				"<setshipto/>"+
				"<plant/>"+
				"<slsoffice/>"+
				"<po>9818738</po>"+
				"<name>smartpart</name>"+
				"<phone>704-599-5967</phone>"+
				"<email>rmylavarapu@smartequip.com</email>"+
				"<shipprtnr>2048</shipprtnr>"+
				"<curr>USD</curr>"+
				"<salestype/>"+
				"<shiptype/>"+
				"<freightterm/>"+
				"<freighttermdesc>Already Chosen</freighttermdesc>"+
				"<shipviaacct/>"+
				"<shipviaid/>"+
				"<shipmethod>Already Chosen:Already Chosen</shipmethod>"+
				"<pricecode/>"+
				"<comment/>"+
				"<payment/>"+
				"<paymentdesc>Already Chosen</paymentdesc>"+
				"<userid>81</userid>"+
				"<total>301.89</total>"+
				"<statusid>2</statusid>"+
				"<order-for>smartpart</order-for>"+
				"<ordertype>18354</ordertype>"+
				"<freighttermlevel/>"+
				"<freighttermservicelevel/>"+
				"<parceltermlevel/>"+
				"<parceltermservicelevel/>"+
				"<freightaccount/>"+
				"<ordertypepartnernumber/>"+
				"<shipmethodid>18355</shipmethodid>"+
				"<reqdate>2010-10-25</reqdate>"+
				"<pterms>18359</pterms>"+
				"<fterms>18360</fterms>"+
				"<prnum/>"+
				"<replytotype>e-mail</replytotype>"+
				"<replyto/>"+
				"<mfrid>667</mfrid>"+
				"<extvendnum>33842</extvendnum>"+
				"<vendorid>667</vendorid>"+
				"<cctype>null</cctype>"+
				"<ccnum>null</ccnum>"+
				"<ccname/>"+
				"<ccdate>null</ccdate>"+
				"<seorderid>101025085613100081</seorderid>"+
				"<reasoncode/>"+
				"<custdbpool>CSUNDEV2</custdbpool>"+
				"<admindbpool>SEADMIN</admindbpool>"+
				"<secustomerid>97</secustomerid>"+
				"<locationID>001</locationID>"+
				"<seOrderID>101025085613100081</seOrderID>"+
				"<reqstoreid/>"+
				"<ordertypedesc>General order</ordertypedesc>"+
				"<paymentTerms/>"+
				"</hdrrec>"+
				//shipping
				"<shippingAddress>"+
				"<name>Sunbelt Rentals</name>"+
				"<addressID>SE</addressID>"+
				"<addr1>1234 Equipment Dr.</addr1>"+
				"<addr2/>"+
				"<city>Charlotte</city>"+
				"<state>NC</state>"+
				"<zip>28262</zip>"+
				"<phone/>"+
				"<cntry/>"+
				"</shippingAddress>"+
				"<dsname/>"+
				"<dsaddr1/>"+
				"<dsaddr2/>"+
				"<dscity/>"+
				"<dsstate/>"+
				"<dszip/>"+
				"<dsphone/>"+
				"<dscountry/>"+
				//billing
				"<billingaddress>"+
				"<bname>CHARLOTTE PC001</bname>"+
				"<baddr1>1234 EQUIPMENT DRIVE</baddr1>"+
				"<baddr2/>"+
				"<bcity>CHARLOTTE</bcity>"+
				"<bstate>NC</bstate>"+
				"<bzip>28262</bzip>"+
				"<bphone>7045995967</bphone>"+
				"<bcountry/>"+
				"</billingaddress>"+
				//part1
				"<partrec>"+
				"<itemnum>9708</itemnum>"+
				"<plant/>"+
				"<partnum>K800002968</partnum>"+
				"<qty>7</qty>"+
				"<confqty/>"+
				"<confdate/>"+
				"<uom>EA</uom>"+
				"<price>14.160</price>"+
				"<netprice>99.12</netprice>"+
				"<discount>0.00</discount>"+
				"<pricomment/>"+
				"<distributorid/>"+
				"<partdesc>PLUG,O-RING [Cat Lift Trucks 9S4190 (K800002968)]</partdesc>"+
				"<partsrc>nGuage</partsrc>"+
				"<shipdate/>"+
				"<shipmethod/>"+
				"<fterms/>"+
				"<ModelNumber/>"+
				"<Make/>"+
				"<Family/>"+
				"<supplierorderid>20462f7d4ecf48c5a45f9e1a00bd54e8</supplierorderid>"+
				"</partrec>"+
				//part2
				"<partrec>"+
				"<itemnum>9709</itemnum>"+
				"<plant/>"+
				"<partnum>91A1206200</partnum>"+
				"<qty>2</qty>"+
				"<confqty/>"+
				"<confdate/>"+
				"<uom>EA</uom>"+
				"<price>17.810</price>"+
				"<netprice>35.62</netprice>"+
				"<discount>0.00</discount>"+
				"<pricomment/>"+
				"<distributorid/>"+
				"<partdesc>BRACKET,HINGE [Cat Lift Trucks 91A1210300 (91A1206200)]</partdesc>"+
				"<partsrc>nGuage</partsrc>"+
				"<shipdate/>"+
				"<shipmethod/>"+
				"<fterms/>"+
				"<ModelNumber/>"+
				"<Make/>"+
				"<Family/>"+
				"<supplierorderid>20462f7d4ecf48c5a45f9e1a00bd54e8</supplierorderid>"+
				"</partrec>"+
				//part3
				"<partrec>"+
				"<itemnum>9710</itemnum>"+
				"<plant/>"+
				"<partnum>91A5128500</partnum>"+
				"<qty>5</qty>"+
				"<confqty/>"+
				"<confdate/>"+
				"<uom>EA</uom>"+
				"<price>33.430</price>"+
				"<netprice>167.15</netprice>"+
				"<discount>0.00</discount>"+
				"<pricomment/>"+
				"<distributorid/>"+
				"<partdesc>PEDAL,ACCEL [Cat Lift Trucks 91A5108500 (91A5128500)]</partdesc>"+
				"<partsrc>nGuage</partsrc>"+
				"<shipdate/>"+
				"<shipmethod/>"+
				"<fterms/>"+
				"<ModelNumber/>"+
				"<Make/>"+
				"<Family/>"+
				"<supplierorderid>20462f7d4ecf48c5a45f9e1a00bd54e8</supplierorderid>"+
				"</partrec>"+

				"</request>"
		);
		return sb;
	}
}
