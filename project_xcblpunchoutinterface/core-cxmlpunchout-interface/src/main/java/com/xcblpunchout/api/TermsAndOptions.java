package com.xcblpunchout.api;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.xcblpunchout.common.Constants;
import com.smartequip.helper.RequestHelper;
import com.xcblpunchout.sebo.TermAndOption;
import com.xcblpunchout.db.TermsAndOptionsPeer;

public class TermsAndOptions extends RequestHelper 
{

	private static final Logger LOGGER = 
        Logger.getLogger(TermsAndOptions.class);
	
	// Constant
    private static final String NODE_NAME_RESPONSE_ROOT = "termsAndOptions";
    
    public void doIt() {
    	// Parse the input XML
        Element requestElement = getRequestData().getContentInDom4J().getRootElement();
        
        String requestType = requestElement.elementTextTrim(Constants.NODE_NAME_REQUEST_TYPE);
        //LOGGER.info("Request Type = " + requestType);
        
        Element userRecordElement = requestElement.element(Constants.NODE_NAME_USER_RECORD);
        
        String userID = userRecordElement.elementText(Constants.NODE_NAME_USERID);
        String password = userRecordElement.elementText(Constants.NODE_NAME_PASSWORD_2);
        String customerID = userRecordElement.elementText(Constants.NODE_NAME_CUSTOMER_ID);
        String customerAcctNo = userRecordElement.elementText(Constants.NODE_NAME_CUSTACCTNUM);
        //LOGGER.info("password:"+password);
        userID = userID.trim();
        password = password.trim();
        customerID = customerID.trim();
        
        try{
        	TermsAndOptionsPeer termsAndOptionsPeer = new TermsAndOptionsPeer();
        	List termList = termsAndOptionsPeer.getTermsAndOptions(userID, password, customerAcctNo);
        	LOGGER.info("termList:"+termList);
        	/*if ((termList == null) 
                    || termList.isEmpty()) {
                negativeAck(termsAndOptionsPeer.getErrorCode(), termsAndOptionsPeer.getErrorMsg());
        	}else {
                
                createResponse(termList);
            }*/
        	
        }catch(Exception e){
        	e.printStackTrace();
        	LOGGER.error("Error while creating terms and options::"+e.getMessage());
        	 negativeAck("0", 
                     e.getMessage());
        }
    }
    
    /**
	 *	Creates and sets the response XML to an success response containing 
	 *	given terms and options information.  
	 *	
	 * @param   termList    the list of terms and options from ERP backend.  
	 */
    protected void createResponse(List termList) {
        
        Element rootElement = DocumentHelper.createElement(NODE_NAME_RESPONSE_ROOT);
        
        Iterator termIterator = termList.iterator();
        while (termIterator.hasNext()) {
            
            TermAndOption term = (TermAndOption) termIterator.next();
            
            appendAddressToResponse(rootElement, term);
        }
        
		rootElement.addElement(Constants.NODE_NAME_REQUEST_STATUS).setText(Constants.STATUS_SUCCESS);
		
		sbXMLResponse.append(rootElement.asXML());
    }
    
    
    /**
     *  Appends one terms and options information to the given response 
     *  element.  
     *  
     * @param   responseElement the response element to append terms and 
     *                          options information to.  
     * @param   term    the terms and options information to be appended.  
     */
    protected void appendAddressToResponse(Element responseElement, TermAndOption term) {
        
        Element recordElement = responseElement.addElement(Constants.NODE_NAME_TERM_RECORD);
        
        recordElement.addElement(Constants.NODE_NAME_TERM_TYPE).setText(term.getType().trim());
        recordElement.addElement(Constants.NODE_NAME_TERM_CODE).setText(term.getCode().trim());
        recordElement.addElement(Constants.NODE_NAME_TERM_DESCRIPTION).setText(term.getDescription().trim());
    }
}
