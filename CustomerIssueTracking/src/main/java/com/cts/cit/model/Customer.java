package com.cts.cit.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Customer {
@NotEmpty(message="Customer Id is required")
	String custId;
@NotEmpty(message="Customer name is required")
	String custName;
@NotEmpty(message="Customer Address is required")
	String custAddress;

@Pattern(regexp="[7-9]{1}[0-9]{9}",message="Mobile number should be 10 digits and starting with digit 7/8/9")
	String custPhone;
@NotEmpty(message="Login Id is required")
	String loginId;
@NotEmpty(message="Password is required")
	String password;
	
	public Customer() {
		super();
	}

	public Customer(String custId, String custName, String custAddress, String custPhone, String loginId,
			String password) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAddress = custAddress;
		this.custPhone = custPhone;
		this.loginId = loginId;
		this.password = password;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custAddress=" + custAddress + ", custPhone="
				+ custPhone + ", loginId=" + loginId + ", password=" + password + "]";
	}
	
	
	
}
