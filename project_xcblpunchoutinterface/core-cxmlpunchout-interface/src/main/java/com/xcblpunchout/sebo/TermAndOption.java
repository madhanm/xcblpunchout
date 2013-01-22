/*
 *	$Source$
 *	$Name$
 *	$Revision: 21009 $
 *	$Date: 2009-05-20 10:39:24 -0400 (Wed, 20 May 2009) $
 *	
 *	Copyright (c) 2003 - 2005, SmartEquip, Inc.  
 *	83 East Avenue, Suite 101, Norwalk, CT 06851  
 *	
 *	Proprietary  
 *	All Rights Reserved
 */
package com.xcblpunchout.sebo;


/**
 *  This is an object representation of one terms and options.  
 */
public class TermAndOption {
    
    // Variable
    private String type = "";
    private String code = "";
    private String description = "";
    private String acctno = "";
    private String isAcctnoRequired = "";
    
    
    // Use default constructor
    
    
    // Access method
    /**
     *  Returns the type of this terms and options.  
     *  
     * @return  the type of this terms and options.  
     */
    public String getType() {
        return  type;
    }
    
    /**
     *  Sets the type of this terms and options.  
     *  
     * @param   type    the type of this terms and options.  
     */
    public void setType(String type) {
        this.type = type;
    }
    
    
    /**
     *  Returns the code of this terms and options.  
     *  
     * @return  the code of this terms and options.  
     */
    public String getCode() {
        return  code;
    }
    
    /**
     *  Sets the code of this terms and options.  
     *  
     * @param   code    the code of this terms and options.  
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    
    /**
     *  Returns the description of this terms and options.  
     *  
     * @return  the description of this terms and options.  
     */
    public String getDescription() {
        return  description;
    }
    
    /**
     *  Sets the description of this terms and options.  
     *  
     * @param   description the description of this terms and options.  
     */
    public void setDescription(String description) {
        this.description = description;
    }

	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}

	public String getAcctno() {
		return acctno;
	}

	public void setIsAcctnoRequired(String isAcctnoRequired) {
		this.isAcctnoRequired = isAcctnoRequired;
	}

	public String getIsAcctnoRequired() {
		return isAcctnoRequired;
	}
}
