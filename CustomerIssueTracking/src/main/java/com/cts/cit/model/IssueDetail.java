package com.cts.cit.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
public class IssueDetail {

    @Id
    int custIssueId;
    @NotEmpty(message = "Date is required")
    String issueReportDate;
	String custId;
	@NotEmpty(message="Category is required")
	String category; //Complaint - Feedback - Suggestion
	@NotEmpty(message = "Description is required")
	String description;
	String issueStatus;//InProgress;Closed;Open
	String ccRepId; // Customer Care Representative Id
	
	
	
	public IssueDetail() {
		super();
	}



	public IssueDetail(int custIssueId, String issueReportDate, String custId, String category, String description,
			String issueStatus, String ccRepId) {
		super();
		this.custIssueId = custIssueId;
		this.issueReportDate = issueReportDate;
		this.custId = custId;
		this.category = category;
		this.description = description;
		this.issueStatus = issueStatus;
		this.ccRepId = ccRepId;
	}



	public int getCustIssueId() {
		return custIssueId;
	}



	public void setCustIssueId(int custIssueId) {
		this.custIssueId = custIssueId;
	}



	public String getIssueReportDate() {
		return issueReportDate;
	}



	public void setIssueReportDate(String issueReportDate) {
		this.issueReportDate = issueReportDate;
	}



	public String getCustId() {
		return custId;
	}



	public void setCustId(String custId) {
		this.custId = custId;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getIssueStatus() {
		return issueStatus;
	}



	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}



	public String getCcRepId() {
		return ccRepId;
	}



	public void setCcRepId(String ccRepId) {
		this.ccRepId = (ccRepId+(int)(Math.random()*(100)+50));
		}



	@Override
	public String toString() {
		return "IssueDetail [custIssueId=" + custIssueId + ", issueReportDate=" + issueReportDate + ", custId=" + custId
				+ ", category=" + category + ", description=" + description + ", issueStatus=" + issueStatus
				+ ", ccRepId=" + ccRepId + "]";
	}
	
	
	
	
}
