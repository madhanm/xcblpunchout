/*
 *	$Source$
 *	$Name$
 *	$Revision: 13006 $
 *	$Date: 2008-03-31 17:00:58 -0400 (Mon, 31 Mar 2008) $
 *
 *	Copyright (c) 2001 - 2005, SmartEquip, Inc.
 *	83 East Avenue, Suite 101, Norwalk, CT 06851
 *
 *	Proprietary
 *	All Rights Reserved
 */

package com.xcblpunchout.sebo;

import java.util.ArrayList;
import java.util.List;

public class PartsAvailability
{
    private String sReqPartNum = "";
    private String sConfirmedPartNum = "";
    private String sRequestedQty = "";
    private String sConfirmedQty = "";
    private String sMaterialDesc = "";
    private String sConfirmedDate = "";
    private String sRequestedDate = "";
    private String sItemNumber = "";
    private String sPlant = "";
    private String sUOM = "";
    private String sPrice = "";
    private String sNetPrice = "";
    private String sDiscount = "";
    private String sCategory = "";
    private String sDocType = "";
    private boolean bProcessed;
    private boolean bZeroAvailSupersed;
    private ArrayList superList = new ArrayList();
    private List retrofitSerials = new ArrayList();
    private boolean supersession=false;
    private String supnum = "";
    private String supdesc = "";
    private String message="";
    private String predecessor = "";

    public boolean isSupersession() {
		return supersession;
	}

	public void setSupersession(boolean supersession) {
		this.supersession = supersession;
	}

	public void setReqPartNum(String part)
    {
        sReqPartNum = part;
    }

    public String getReqPartNum()
    {
        return sReqPartNum;
    }

    public void setConfirmedPartNum(String part)
    {
        sConfirmedPartNum = part;
    }

    public String getConfirmedPartNum()
    {
        return sConfirmedPartNum;
    }

    public void setRequestedQty(String qty)
    {
        sRequestedQty = qty;
    }

    public String getRequestedQty()
    {
        return sRequestedQty;
    }

    public void setConfirmedQty(String qty)
    {
        sConfirmedQty = qty;
    }

    public String getConfirmedQty()
    {
        return sConfirmedQty;
    }

    public void setMaterialDesc(String desc)
    {
        sMaterialDesc = desc;
    }

    public String getMaterialDesc()
    {
        return sMaterialDesc;
    }

    public void setConfirmedDate(String date)
    {
        sConfirmedDate = date;
    }

    public String getConfirmedDate()
    {
        return sConfirmedDate;
    }

    public void setItemNumber(String itemnum)
    {
        sItemNumber = itemnum;
    }

    public String getItemNumber()
    {
        return sItemNumber;
    }

    public void setPlant(String plant)
    {
        sPlant = plant;
    }

    public String getPlant()
    {
        return sPlant;
    }

    public void setUOM(String uom)
    {
        sUOM = uom;
    }

    public String getUOM()
    {
        return sUOM;
    }

    public void setPrice(String Price)
    {
        sPrice = Price;
    }

    public String getPrice()
    {
        return sPrice;
    }

    public void setNetPrice(String NetPrice)
    {
        sNetPrice = NetPrice;
    }

    public String getNetPrice()
    {
        return sNetPrice;
    }

    public void setDiscount(String Discount)
    {
        sDiscount = Discount;
    }

    public String getDiscount()
    {
        return sDiscount;
    }

    public void setCategory(String Category)
    {
        sCategory = Category;
    }

    public String getCategory()
    {
        return sCategory;
    }

    public void setProcessed(boolean proc)
    {
        bProcessed = proc;
    }

    public boolean isProcessed()
    {
        return bProcessed;
    }

    public void setZeroAvailSupersed(boolean flag)
    {
        bZeroAvailSupersed = flag;
    }

    public boolean isZeroAvailSupersed()
    {
        return bZeroAvailSupersed;
    }

  
    public ArrayList getSuperList() {
		return superList;
	}

	public void setSuperList(ArrayList superList) {
		this.superList = superList;
	}

	public String getSupnum() {
		return supnum;
	}

	public void setSupnum(String supnum) {
		this.supnum = supnum;
	}

	public String getSupdesc() {
		return supdesc;
	}

	public void setSupdesc(String supdesc) {
		this.supdesc = supdesc;
	}

	public void setRequestedDate(String RequestedDate)
    {
        sRequestedDate = RequestedDate;
    }

    public String getRequestedDate()
    {
        return sRequestedDate;
    }

    public List getRetrofitSerials()
    {
        if (null == retrofitSerials)
        {
            retrofitSerials = new ArrayList();
        }
        return retrofitSerials;
    }

    public void setRetrofitSerials(List retrofitSerials)
    {
        this.retrofitSerials = retrofitSerials;
    }

//    public void addRetrofitSerials(PrSerialNum prSerialNum)
//    {
//        if(null != prSerialNum)
//            this.retrofitSerials.add(prSerialNum);
//    }
//
//    public List getRetrofitSerialInStringList()
//    {
//        List serials = new ArrayList();
//        for(int k = 0; k < retrofitSerials.size(); k++)
//        {
//            PrSerialNum psb = (PrSerialNum) retrofitSerials.get(k);
//            serials.add(psb.getSerialSN());
//        }
//        return serials;
//    }
    public String getSDocType() {
		return sDocType;
	}

	public void setSDocType(String docType) {
		sDocType = docType;
	}
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setPredecessor(String predecessor){
		this.predecessor = predecessor;
	}

	public String getPredecessor(){
		return this.predecessor;
	}

}
