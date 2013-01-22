package com.cxmlpunchout.api;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import junit.framework.TestCase;

import org.junit.Test;

public class OrderCreateTest extends TestCase {

	private final String endPoint = "http://tradingpartner.qa.ehub.lifttrucksolutions.com/PurchaseOrderService.svc/submit";

	@Test
	public void testPurchaseOrderService() throws Exception{
		URL endpoint = new URL(endPoint);
		HttpURLConnection httpConnection = (HttpURLConnection)endpoint.openConnection();
		assertTrue( "PurchaseOrderService connection success ", httpConnection.getResponseCode() == HttpServletResponse.SC_OK );

		/*
		httpConnection.setDoInput(true);
		httpConnection.setDoOutput(true);
		httpConnection.setUseCaches(false);
		httpConnection.setRequestMethod("POST");
		httpConnection.setRequestProperty("Content-Length", String.valueOf(cxmlMessage.getBytes().length ));
		httpConnection.setRequestProperty("Content-type","text/xml");
		httpConnection.setRequestProperty("charset","UTF-8");
		httpConnection.setRequestProperty("Connection","Keep-Alive");
		httpConnection.setAllowUserInteraction(true);
		 */
	}
}
