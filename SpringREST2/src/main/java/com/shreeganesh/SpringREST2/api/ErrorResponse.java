package com.shreeganesh.SpringREST2.api;

import java.util.Date;

public class ErrorResponse {

	private String errormessage;
	private String errortype;
	private Date errordate;
	public String getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	public String getErrortype() {
		return errortype;
	}
	public void setErrortype(String errortype) {
		this.errortype = errortype;
	}
	public Date getErrordate() {
		return errordate;
	}
	public void setErrordate(Date errordate) {
		this.errordate = errordate;
	}
	@Override
	public String toString() {
		return "ErrorResponse [errormessage=" + errormessage + ", errortype=" + errortype + ", errordate=" + errordate
				+ "]";
	}
	
}
